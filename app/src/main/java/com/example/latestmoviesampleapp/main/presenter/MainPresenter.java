package com.example.latestmoviesampleapp.main.presenter;

import com.example.latestmoviesampleapp.main.model.Result;

import java.util.List;

/**
 * Created by piubips on 20/02/2017.
 */

public interface MainPresenter {
    public List<Result> loadDatas();
    void clickMovieItem(Result itemResult);


}
