package br.com.fiap.serverless.model.dto;

import br.com.fiap.serverless.model.Trip;

import java.time.LocalDate;

public class TripDto {

    private final Integer id;

    private final LocalDate date;

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

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
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
