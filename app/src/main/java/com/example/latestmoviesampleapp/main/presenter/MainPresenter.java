package com.example.latestmoviesampleapp.main.presenter;

import java.util.HashMap;

/**
 * Created by piubips on 20/02/2017.
 */

public interface MainPresenter {

  //method to get Genre from API
    void getMovieGenres();

    //method to get MovieList from API
    void getMovieList(final HashMap<Integer, String> genericMap) ;


}
