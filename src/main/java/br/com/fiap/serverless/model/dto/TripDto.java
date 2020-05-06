package br.com.fiap.serverless.model.dto;

import br.com.fiap.serverless.model.Trip;

public class TripDto {

    private final String id;

    private final String date;

    private final String country;

    private final String city;

    private final String photosUrl;

    public TripDto(Trip trip) {
        this.id = trip.getId();
        this.date = trip.getDate();
        this.country = trip.getCountry();
        this.city = trip.getCity();
        this.photosUrl = trip.getPhotosUrl();
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }
}
