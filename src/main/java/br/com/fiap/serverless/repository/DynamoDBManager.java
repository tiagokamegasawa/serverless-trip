package br.com.fiap.serverless.repository;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBManager {

	private static DynamoDBMapper mapper;

	static {
		
		AmazonDynamoDB ddb = null;
		final String endpoint = System.getenv("ENDPOINT_OVERRIDE");
		final String signingRegion = System.getenv("REGION");

        if (endpoint != null && !endpoint.isEmpty()) {
        	EndpointConfiguration endpointConfiguration = new EndpointConfiguration(endpoint, "local");
        	ddb = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(endpointConfiguration).build();
        } else {
        	ddb = AmazonDynamoDBClientBuilder.defaultClient();
        }

		mapper = new DynamoDBMapper(ddb);
	}

	public static DynamoDBMapper mapper() {
		return DynamoDBManager.mapper;
	}

}