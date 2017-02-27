package com.example.latestmoviesampleapp.main.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.latestmoviesampleapp.BaseActivity;
import com.example.latestmoviesampleapp.R;
import com.example.latestmoviesampleapp.main.adapter.CustomGridAdapter;
import com.example.latestmoviesampleapp.main.model.Result;
import com.example.latestmoviesampleapp.main.presenter.MainPresenterImpl;
import com.example.latestmoviesampleapp.main.view.MainView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by piubips on 20/02/2017.
 */

public class MainActivity extends BaseActivity implements MainView {

    RecyclerView recyclerView;
    ProgressDialog mProgressDialog;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Retrofit MovieList Example");

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setLogo(R.mipmap.ic_launcher);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));


        initRecycleView();
        MainPresenterImpl  mPresenter = new MainPresenterImpl(this, this);
        mPresenter.getMoviesList();


    }

    private void initRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);


        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showProgress() {
         mProgressDialog=new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Please Wait!");
        mProgressDialog.show();


    }


    private void hideProgress() {
      mProgressDialog.hide();
    }

    @Override
    public void showMovieClickedMessage(Result result) {
        Toast.makeText(MainActivity.this, String.format(getString(R.string.main_toast_weather_item_click), result.getTitle()), Toast.LENGTH_LONG).show();


    }

    @Override
    public void showWeathers(List<Result> resultList, HashMap<Integer,String> genericMap) {
        hideProgress();
        CustomGridAdapter mCustomGridAdapter = new CustomGridAdapter(MainActivity.this, this, resultList, genericMap);
        recyclerView.setAdapter(mCustomGridAdapter);

    }



    @Override
    public void showError(String message) {
        hideProgress();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
