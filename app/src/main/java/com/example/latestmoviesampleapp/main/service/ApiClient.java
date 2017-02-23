package com.example.latestmoviesampleapp.main.service;

/**
 * Created by piubips on 22/02/2017.
 */

import com.example.latestmoviesampleapp.main.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class ApiClient {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


  public interface ApiInteface{

       @GET("discover/movie?sort_by=popularity.desc?")
      //  @GET("movie/top_rated")
        Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);
    }


    public  ApiInteface getClient() {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInteface.class);
    }
}
//http://api.themoviedb.org/3/movie/top_rated?api_key=29e344c1565e9fcc38d011ea8fd4ff33

//https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc?&api_key=29e344c1565e9fcc38d011ea8fd4ff33