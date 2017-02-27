package com.example.latestmoviesampleapp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.latestmoviesampleapp.R;
import com.example.latestmoviesampleapp.main.model.Result;
import com.example.latestmoviesampleapp.main.view.MainView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by piubips on 20/02/2017.
 */

public class CustomGridAdapter extends RecyclerView.Adapter<CustomGridViewHolder> {

    Context mContext;
    MainView mListener;

    HashMap<Integer, String> mGeneric;
    List<Result> resultList;

    public CustomGridAdapter(Context context, MainView listener, List<Result> result, HashMap<Integer, String> genericMap) {

        mContext = context;

        mListener = listener;

        resultList = result;

        mGeneric = genericMap;
    }


    @Override
    public CustomGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_view_list, parent, false);
        return new CustomGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomGridViewHolder holder, int position) {


        holder.bindView(mContext, resultList.get(position), mGeneric,mListener);


    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


}
