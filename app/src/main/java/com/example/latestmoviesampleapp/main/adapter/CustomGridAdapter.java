package com.example.latestmoviesampleapp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.latestmoviesampleapp.R;
import com.example.latestmoviesampleapp.main.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piubips on 20/02/2017.
 */

public class CustomGridAdapter extends RecyclerView.Adapter<CustomGridAdapter.CustomGridViewHolder>{

    private final Context mContext;
    private final CustomGridItemClickListener mListener;


    private List <Result> resultList=new ArrayList<>();

    public CustomGridAdapter(Context context,CustomGridItemClickListener listener, List<Result> result) {

        mContext=context;

        mListener = listener;

        resultList=result;
    }


    @Override
    public CustomGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.card_view_list,parent,false);
        return new CustomGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomGridViewHolder holder, int position) {
        Result result=resultList.get(position);
        holder.movieNameText.setText(result.getOriginalTitle());
        holder.releaseDateText.setText(result.getReleaseDate());
        holder.ratingText.setText(result.getVoteAverage().toString());

        //TODO genre and Image
      //  holder.genreText.setText(result.getGenreIds().toString());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public interface CustomGridItemClickListener{
        void onMovieItemClick(Result result);
    }

    protected  class CustomGridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private   TextView movieNameText;
        private  TextView genreText;
        private  TextView ratingText;
        private  TextView releaseDateText;
        private  ImageView movieImage;

        public CustomGridViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            movieNameText = (TextView) itemView.findViewById(R.id.name_text);
            genreText = (TextView) itemView.findViewById(R.id.genre_text);
            ratingText = (TextView) itemView.findViewById(R.id.rating_text);
            releaseDateText = (TextView) itemView.findViewById(R.id.release_date_text);
            movieImage=(ImageView)itemView.findViewById(R.id.movie_photo);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Result result = resultList.get(position);

            mListener.onMovieItemClick(result);

        }
    }
}
