package com.example.latestmoviesampleapp.main.view;

import com.example.latestmoviesampleapp.main.model.Result;

import java.util.HashMap;
import java.util.List;

/**
 * Created by piubips on 21/02/2017.
 */

public interface MainView {

    //method to show ProgressDialog
    void showProgress();

    //method to hide ProgressDialog
    void hideProgress();

    //method will be called when recyclerview row will be clicked
    void showMovieClickedMessage(Result result);

    //display list of movies in recylerview
    void displayMovies(List<Result> resultList, HashMap<Integer, String> genericKeyValuePair);

    //method to show any error
    void showError(String message);


}
