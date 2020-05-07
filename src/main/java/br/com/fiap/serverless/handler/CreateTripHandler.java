package br.com.fiap.serverless.handler;

import br.com.fiap.serverless.model.HandlerRequest;
import br.com.fiap.serverless.model.HandlerResponse;
import br.com.fiap.serverless.model.Trip;
import br.com.fiap.serverless.model.dto.CreateTripResponse;
import br.com.fiap.serverless.repository.TripRepository;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Random;

public class CreateTripHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    private final TripRepository repository = new TripRepository();

    private final Log logger = LogFactory.getLog(CreateTripHandler.class);

    @Override
    public HandlerResponse handleRequest(final HandlerRequest request, final Context context) {

        Trip trip = null;
        try {
            trip = new ObjectMapper().readValue(request.getBody(), Trip.class);
        } catch (IOException e) {
            logger.error(e);
            return HandlerResponse.builder().setStatusCode(400).setRawBody("Erro ao criar um registro de Trip").build();
        }
        context.getLogger().log("Criando um novo registro");
        trip.setPhotosUrl(createBucketName(trip));
        final Trip savedTrip = repository.save(trip);

        return HandlerResponse.builder().setStatusCode(201).setObjectBody(new CreateTripResponse(savedTrip.getId(), savedTrip.getPhotosUrl())).build();
    }

    private String createBucketName(Trip trip) {
        StringBuilder sb = new StringBuilder();
        sb.append(trip.getCountry());
        sb.append("-");
        sb.append(trip.getCity());
        sb.append("-");
        sb.append(trip.getDate());
        sb.append("-");
        sb.append(new Random().ints(6, 0, 9).limit(6).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
        return sb.toString();
    }

}
