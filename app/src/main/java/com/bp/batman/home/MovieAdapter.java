package com.bp.batman.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bp.batman.R;
import com.bp.batman.data.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.movie_item_raw,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Movie movie= movieList.get(position);
        Picasso.get().load(movie.getPoster()).into(holder.img);
        holder.txt_title.setText(movie.getTitle());
        holder.txt_year.setText(movie.getYear());
        holder.txt_type.setText(movie.getType());

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView txt_title,txt_year,txt_type;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_thumbnail);
            txt_title = itemView.findViewById(R.id.txt_movie_title);
            txt_year = itemView.findViewById(R.id.txt_year);
            txt_type = itemView.findViewById(R.id.txt_type);
        }
    }
}
