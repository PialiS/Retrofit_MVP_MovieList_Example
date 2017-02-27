package com.example.latestmoviesampleapp.main.service;

/**
 * Created by piubips on 22/02/2017.
 */

import com.example.latestmoviesampleapp.Utils;
import com.example.latestmoviesampleapp.main.model.GenreResponse;
import com.example.latestmoviesampleapp.main.model.MovieResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class ApiClient {

    private static Retrofit retrofit = null;


  public interface ApiInteface{

       @GET("discover/movie?sort_by=popularity.desc")
      //  @GET("movie/top_rated")
        Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

      @GET("genre/movie/list")
     Call<GenreResponse> getGenreMovies(@Query("api_key") String apiKey);
    }


    public  ApiInteface getClient() {

        if (retrofit==null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiInteface.class);
    }
}
//http://api.themoviedb.org/3/movie/top_rated?api_key=29e344c1565e9fcc38d011ea8fd4ff33

//https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc?&api_key=29e344c1565e9fcc38d011ea8fd4ff33

//https://image.tmdb.org/t/p/w640/vxuoMW6YBt6UsxvMfRNwRl9LtWS.jpg

//https://api.themoviedb.org/3/genre/movie/list?api_key=29e344c1565e9fcc38d011ea8fd4ff33&language=en-US