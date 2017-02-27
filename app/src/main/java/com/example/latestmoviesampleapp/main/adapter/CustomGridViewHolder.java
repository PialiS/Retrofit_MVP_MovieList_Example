package com.example.latestmoviesampleapp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.latestmoviesampleapp.R;
import com.example.latestmoviesampleapp.Utils;
import com.example.latestmoviesampleapp.main.model.Result;
import com.example.latestmoviesampleapp.main.view.MainView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * Created by piubips on 24/02/2017.
 */

public class CustomGridViewHolder extends RecyclerView.ViewHolder {

   // MainView mListener;

    private TextView movieNameText;
    private TextView genreText;
    private TextView ratingText;
    private TextView releaseDateText;
    private ImageView movieImage;


    public CustomGridViewHolder(View itemView) {
        super(itemView);


        movieNameText = (TextView) itemView.findViewById(R.id.name_text);
        genreText = (TextView) itemView.findViewById(R.id.genre_text);
        ratingText = (TextView) itemView.findViewById(R.id.rating_text);
        releaseDateText = (TextView) itemView.findViewById(R.id.release_date_text);
        movieImage = (ImageView) itemView.findViewById(R.id.movie_photo);
    }

    public void bindView(Context context, final Result result, HashMap<Integer, String> mGeneric,final MainView mListener) {

        movieNameText.setText(result.getOriginalTitle());
        releaseDateText.setText(result.getReleaseDate());
        ratingText.setText(result.getVoteAverage().toString());

        String imageUrl = Utils.IMAGE_URL + result.getPosterPath();

        Picasso.with(context).load(imageUrl).placeholder(R.drawable.ic_action_refresh).into(movieImage);

        String genericTag = null;
        if (result.getGenreIds()!=null & !result.getGenreIds().isEmpty()){

        for(int i=0;i<result.getGenreIds().size();i++){
           if(mGeneric.containsKey(result.getGenreIds().get(i))){

               genericTag= TextUtils.isEmpty(genericTag) ? mGeneric.get(result.getGenreIds().get(i)): genericTag+","+ mGeneric.get(result.getGenreIds().get(i));


           }
        }

        }


       genreText.setText(TextUtils.isEmpty(genericTag)? "No Information Available" : genericTag);




        itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                    mListener.showMovieClickedMessage(result);




            }
        });
    }
}
