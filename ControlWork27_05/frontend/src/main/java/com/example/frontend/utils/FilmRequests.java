package com.example.frontend.utils;

import com.example.frontend.schemas.Film;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FilmRequests {
    public static String executeGet() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/film").asJson();
        return apiResponse.getBody().toString();
    }
}
