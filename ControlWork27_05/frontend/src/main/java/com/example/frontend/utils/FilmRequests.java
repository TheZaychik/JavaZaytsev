package com.example.frontend.utils;

import com.example.frontend.schemas.Film;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class FilmRequests {
    public static List<Film> executeGet() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/film").asJson();
        return new Gson().fromJson(apiResponse.getBody().toString(), new TypeToken<List<Film>>(){}.getType());
    }
}
