package br.com.fiap.serverless.handler;

import br.com.fiap.serverless.model.HandlerRequest;
import br.com.fiap.serverless.model.HandlerResponse;
import br.com.fiap.serverless.model.Trip;
import br.com.fiap.serverless.repository.TripRepository;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Collections;
import java.util.List;

public class GetTripsByPeriodHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    private final TripRepository repository = new TripRepository();

    @Override
    public HandlerResponse handleRequest(HandlerRequest request, Context context) {

        final String start = request.getQueryStringParameters().get("start");
        final String end = request.getQueryStringParameters().get("end");

        final List<Trip> trips = this.repository.findByPeriod(start, end);

        if (trips == null || trips.isEmpty()) {
            return HandlerResponse.builder().setStatusCode(200).setObjectBody(Collections.emptyList()).build();
        }

        return HandlerResponse.builder().setStatusCode(200).setObjectBody(trips).build();
    }
}
