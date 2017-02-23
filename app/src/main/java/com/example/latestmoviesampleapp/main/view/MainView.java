package com.example.latestmoviesampleapp.main.view;

import com.example.latestmoviesampleapp.main.model.Result;

import java.util.List;

/**
 * Created by piubips on 21/02/2017.
 */

public interface MainView {

    public void showProgress();

    public void hideProgress();

    void showMovieClickedMessage(Result result);

    void showWeathers(List<Result> resultList);

    void showConnectionError();

}
