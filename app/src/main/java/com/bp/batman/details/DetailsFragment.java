package com.bp.batman.details;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;
import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieRepository;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class DetailsFragment extends BaseFragment implements DetailsContract.View{

    DetailsContract.Presenter presenter;
    Toolbar toolbar;
    ImageView img;
    Bundle bundle;
    TextView txt_title_details,txt_type_details,txt_year_details,txt_rated_details,txt_released_details;
    TextView txt_run_time_details,txt_plot_details,txt_country_details,txt_language_details,txt_genre_details;
    TextView txt_director_details,txt_writer_details,txt_actors_details,txt_awards_details,txt_dvd_details;
    TextView txt_box_office_details,txt_production_details,txt_website_details,txt_metaScore_details,txt_imdb_rating_details;
    TextView txt_imdb_votes_details;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle= getArguments();
        assert bundle != null;
        String imdbId= bundle.getString("imdbId");

        presenter=new DetailsPresenter(new MovieRepository(),imdbId);

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    public void setUpViews() {

        toolbar = rootView.findViewById(R.id.toolbar_details);
        collapsingToolbarLayout = rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        img = rootView.findViewById(R.id.img_details);

        txt_title_details = rootView.findViewById(R.id.txt_title_details);
        txt_type_details = rootView.findViewById(R.id.txt_type_details);
        txt_year_details = rootView.findViewById(R.id.txt_year_details);
        txt_rated_details = rootView.findViewById(R.id.txt_rated_details);
        txt_released_details = rootView.findViewById(R.id.txt_released_details);
        txt_run_time_details = rootView.findViewById(R.id.txt_run_time_details);
        txt_plot_details = rootView.findViewById(R.id.txt_plot_details);
        txt_country_details = rootView.findViewById(R.id.txt_country_details);
        txt_language_details = rootView.findViewById(R.id.txt_language_details);
        txt_genre_details = rootView.findViewById(R.id.txt_genre_details);
        txt_director_details = rootView.findViewById(R.id.txt_director_details);
        txt_writer_details = rootView.findViewById(R.id.txt_writer_details);
        txt_actors_details = rootView.findViewById(R.id.txt_actors_details);
        txt_awards_details = rootView.findViewById(R.id.txt_awards_details);
        txt_dvd_details = rootView.findViewById(R.id.txt_dvd_details);
        txt_box_office_details = rootView.findViewById(R.id.txt_box_office_details);
        txt_production_details = rootView.findViewById(R.id.txt_production_details);
        txt_website_details = rootView.findViewById(R.id.txt_website_details);
        txt_metaScore_details = rootView.findViewById(R.id.txt_metaScore_details);
        txt_imdb_rating_details = rootView.findViewById(R.id.txt_imdb_rating_details);
        txt_imdb_votes_details = rootView.findViewById(R.id.txt_imdb_votes_details);

        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) Objects.requireNonNull(getActivity())).onBackPressed();
            }
        });




    }


    @Override
    public void showDetails(Movie movie) {
        Picasso.get().load(movie.getPoster()).into(img);
        collapsingToolbarLayout.setTitle(movie.getTitle());

        txt_title_details.setText(movie.getTitle());
        txt_type_details.setText(movie.getType());
        txt_year_details.setText(movie.getYear());
        txt_rated_details.setText(movie.getRated());
        txt_released_details.setText(movie.getReleased());
        txt_run_time_details.setText(movie.getRuntime());
        txt_plot_details.setText(movie.getPlot());
        txt_country_details.setText(movie.getCountry());
        txt_language_details.setText(movie.getLanguage());
        txt_genre_details.setText(movie.getGenre());
        txt_director_details.setText(movie.getDirector());
        txt_writer_details.setText(movie.getWriter());
        txt_actors_details.setText(movie.getActors());
        txt_awards_details.setText(movie.getAwards());
        txt_dvd_details.setText(movie.getDVD());
        txt_box_office_details.setText(movie.getBoxOffice());
        txt_production_details.setText(movie.getProduction());
        txt_website_details.setText(movie.getWebsite());
        txt_metaScore_details.setText(movie.getMetascore());
        txt_imdb_rating_details.setText(movie.getImdbRating());
        txt_imdb_votes_details.setText(movie.getImdbVotes());

    }

    @Override
    public void showError(String e) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}

