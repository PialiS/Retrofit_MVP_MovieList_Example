package com.example.latestmoviesampleapp.main.view;

import com.example.latestmoviesampleapp.main.model.Result;

import java.util.HashMap;
import java.util.List;

/**
 * Created by piubips on 21/02/2017.
 */

public interface MainView {

    void showProgress();



    void showMovieClickedMessage(Result result);

    void showWeathers(List<Result> resultList, HashMap<Integer, String> genericKeyValuePair);


    void showError(String message);

}
