package br.com.fiap.serverless.model.dto;

public class CreateTripResponse {

    private final String id;

    private final String photosUrl;

    public CreateTripResponse(String id,
                              String photosUrl) {
        this.id = id;
        this.photosUrl = photosUrl;
    }

    public String getId() {
        return id;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }
}
