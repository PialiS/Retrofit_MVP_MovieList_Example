package com.example.latestmoviesampleapp.main.presenter;

import android.content.Context;

import com.example.latestmoviesampleapp.BasePresenter;
import com.example.latestmoviesampleapp.Utils;
import com.example.latestmoviesampleapp.main.model.GenreResponse;
import com.example.latestmoviesampleapp.main.model.MovieResponse;
import com.example.latestmoviesampleapp.main.model.Result;
import com.example.latestmoviesampleapp.main.service.ApiClient;
import com.example.latestmoviesampleapp.main.view.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by piubips on 20/02/2017.
 */

public class MainPresenterImpl extends BasePresenter implements MainPresenter {


    private MainView mView;
    private MainPresenterImpl mMainPresenterImpl;
    private ApiClient apiClient;
    List<Result> resultList = new ArrayList<>();
    private Context context;

    public MainPresenterImpl(Context context, MainView mainView) {
        this.context = context;
        this.mView = mainView;
        this.apiClient = new ApiClient();
    }

    @Override
    public void getMoviesList() {
        mView.showProgress();

        apiClient.getClient().getGenreMovies(Utils.API_KEY).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                HashMap<Integer, String> genericMap = new HashMap<>();
                GenreResponse responseReceived = response.body();

                if (responseReceived.getGenres() != null & !responseReceived.getGenres().isEmpty()) {
                    for (int i = 0; i < responseReceived.getGenres().size(); i++) {
                        genericMap.put(responseReceived.getGenres().get(i).getId(), responseReceived.getGenres().get(i).getName());
                    }
                }

                loadMovies(genericMap);
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                  mView.hideProgress();
                mView.showError("Error while getching generic Tag");
            }
        });


    }

//
//    @Override
//    public void loadMovies( final boolean isMapAvailable, final HashMap<Integer, String> genericMap) {
//        if (isMapAvailable){
//            mView.showProgress();
//        }
//        if (!genericMap.isEmpty()) {
//            apiClient.getClient().getPopularMovies(Utils.API_KEY).enqueue(new Callback<MovieResponse>() {
//                @Override
//                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                    mView.hideProgress();
//                    MovieResponse responseReceived = response.body();
//
//                    mView.displayMovies(isMapAvailable,responseReceived.getResults(), genericMap);
//
//                }
//
//                @Override
//                public void onFailure(Call<MovieResponse> call, Throwable t) {
//                      mView.hideProgress();
//                    mView.showError("Error while fetching movielist");
//                }
//            });
//
//        }
//
//        else {
//              mView.hideProgress();
//            mView.showError("No Movie List Available");
//        }

        @Override
        public void loadMovies( final HashMap<Integer, String> genericMap) {

                apiClient.getClient().getPopularMovies(Utils.API_KEY).enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        mView.hideProgress();
                        MovieResponse responseReceived = response.body();

                        mView.displayMovies(responseReceived.getResults(), genericMap);

                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        mView.hideProgress();
                        mView.showError("Error while fetching movielist");
                    }
                });

            }






}
