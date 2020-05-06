package br.com.fiap.serverless.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "trip")
public class Trip {

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBIndexRangeKey(attributeName = "date", globalSecondaryIndexName = "dateIndex")
    private String date;

    @DynamoDBIndexHashKey(attributeName = "country", globalSecondaryIndexName = "dateIndex")
    private String country;

    @DynamoDBAttribute(attributeName = "city")
    private String city;

    @DynamoDBAttribute(attributeName = "photosUrl")
    private String photosUrl;

    public Trip() {
    }

    public Trip(String id,
                String date,
                String country,
                String city,
                String photosUrl) {
        this.id = id;
        this.date = date;
        this.country = country;
        this.city = city;
        this.photosUrl = photosUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }
}
