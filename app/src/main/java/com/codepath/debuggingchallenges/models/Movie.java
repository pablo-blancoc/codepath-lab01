package com.codepath.debuggingchallenges.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    private final String title;
    private final String posterUrl;
    private final double rating;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterUrl = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.rating = jsonObject.getDouble("vote_average");
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                movies.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                Log.e("Movie", "Error in fromJSONArray", e);
                e.printStackTrace();
            }
        }
        return movies;
    }
}
