package com.example.latestmoviesampleapp.main.presenter;

import java.util.HashMap;

/**
 * Created by piubips on 20/02/2017.
 */

public interface MainPresenter {
    void getMoviesList();
    void loadMovies( boolean isMapAvailable, final HashMap<Integer, String> genericMap) ;


}
