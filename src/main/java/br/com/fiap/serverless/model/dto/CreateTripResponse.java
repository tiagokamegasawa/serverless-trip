package br.com.fiap.serverless.model.dto;

public class CreateTripResponse {

    private final Integer id;

    private final String photosUrl;

    public CreateTripResponse(Integer id,
                              String photosUrl) {
        this.id = id;
        this.photosUrl = photosUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }
}
