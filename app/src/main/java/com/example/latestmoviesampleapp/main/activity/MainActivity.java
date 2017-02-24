package com.example.latestmoviesampleapp.main.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piubips on 20/02/2017.
 */

public class MainActivity extends BaseActivity implements MainView, CustomGridAdapter.CustomGridItemClickListener {

    private MainPresenterImpl mPresenter;
    private MainView mainView;

    RecyclerView recyclerView;
    private GridLayoutManager mGridLayoutManager;

    List<Result> resultList;
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

        mPresenter = new MainPresenterImpl(this,this);
        mPresenter.loadDatas();
        resultList=new ArrayList<>();
        initRecycleView();


    }

    private void initRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setHasFixedSize(true);

        CustomGridAdapter mCustomGridAdapter = new CustomGridAdapter(MainActivity.this,this, resultList);
        recyclerView.setAdapter(mCustomGridAdapter);
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
        if(id == R.id.action_refresh){
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMovieItemClick(Result result) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMovieClickedMessage(Result result) {
      //  Toast.makeText(this, String.format(getString(R.string.main_toast_weather_item_click), resultList.get(index).getTitle()), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showWeathers(List<Result> resultList) {

    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, R.string.main_error_connection, Toast.LENGTH_SHORT).show();

    }
}
