package br.com.fiap.serverless.repository;

import br.com.fiap.serverless.model.Trip;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripRepository {

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	public Trip save(final Trip trip) {
		mapper.save(trip);
		return trip;
	}

	public List<Trip> findByPeriod(final String start, final String end) {

		final Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":start", new AttributeValue().withS(start));
		eav.put(":end", new AttributeValue().withS(end));

		final DynamoDBQueryExpression<Trip> queryExpression = new DynamoDBQueryExpression<Trip>()
				.withKeyConditionExpression("date between :start and :end")
				.withExpressionAttributeValues(eav);

		return mapper.query(Trip.class, queryExpression);
	}

	public Trip findById(final Integer id) {
		return mapper.load(Trip.class, id);
	}
}