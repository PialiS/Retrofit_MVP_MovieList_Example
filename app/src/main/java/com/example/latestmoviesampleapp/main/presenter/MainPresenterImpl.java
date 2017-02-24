package com.example.latestmoviesampleapp.main.presenter;

import android.content.Context;

import com.example.latestmoviesampleapp.BasePresenter;
import com.example.latestmoviesampleapp.Utils;
import com.example.latestmoviesampleapp.main.model.MovieResponse;
import com.example.latestmoviesampleapp.main.model.Result;
import com.example.latestmoviesampleapp.main.service.ApiClient;
import com.example.latestmoviesampleapp.main.view.MainView;

import java.util.ArrayList;
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
    List<Result> resultList=new ArrayList<>();
    private Context context;

//    public MainPresenterImpl(MainView mainView, MainPresenterImpl mainPresenter) {
//        mView = mainView;
//        mMainPresenterImpl = mainPresenter;
//    }

    public MainPresenterImpl(Context context, MainView mainView) {
        this.context = context;
        this.mView = mainView;
         this.apiClient=new ApiClient();
    }



    @Override
    public List<Result> loadDatas() {
        apiClient.getClient().getPopularMovies(Utils.API_KEY).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse responseReceived = response.body();


                resultList = responseReceived.getResults();

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                try {
                    throw new InterruptedException("error while communicating with server!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return resultList;
    }

    @Override
    public void clickMovieItem(Result itemResult) {
        mView.showMovieClickedMessage(itemResult);

    }
}
