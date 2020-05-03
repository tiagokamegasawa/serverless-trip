package br.com.fiap.serverless.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDate;

@DynamoDBTable(tableName = "trip")
public class Trip {

    @DynamoDBHashKey(attributeName = "id")
    private Integer id;

    @DynamoDBRangeKey(attributeName = "date")
    private LocalDate date;

    @DynamoDBAttribute(attributeName = "country")
    private String country;

    @DynamoDBAttribute(attributeName = "city")
    private String city;

    @DynamoDBAttribute(attributeName = "photosUrl")
    private String photosUrl;

    public Trip() {
    }

    public Trip(Integer id,
                LocalDate date,
                String country,
                String city,
                String photosUrl) {
        this.id = id;
        this.date = date;
        this.country = country;
        this.city = city;
        this.photosUrl = photosUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
