package br.com.fiap.serverless.handler;

import br.com.fiap.serverless.model.HandlerRequest;
import br.com.fiap.serverless.model.HandlerResponse;
import br.com.fiap.serverless.model.Trip;
import br.com.fiap.serverless.model.dto.CreateTripResponse;
import br.com.fiap.serverless.repository.TripRepository;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CreateTripHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    private final TripRepository repository = new TripRepository();

    @Override
    public HandlerResponse handleRequest(final HandlerRequest request, final Context context) {

        Trip trip = null;
        try {
            trip = new ObjectMapper().readValue(request.getBody(), Trip.class);
        } catch (IOException e) {
            return HandlerResponse.builder().setStatusCode(400).setRawBody("There is a error in your Trip!").build();
        }
        context.getLogger().log("Creating a new trip record");
        final Trip savedTrip = repository.save(trip);

        return HandlerResponse.builder().setStatusCode(201).setObjectBody(new CreateTripResponse(savedTrip.getId(), "TODO")).build();
    }
}
