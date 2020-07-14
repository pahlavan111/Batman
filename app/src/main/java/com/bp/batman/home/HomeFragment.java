package com.bp.batman.home;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;
import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieRepository;
import java.util.List;


public class HomeFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter presenter;
    private RecyclerView rv_movie;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(new MovieRepository(getViewContext()));
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setUpViews() {
        rv_movie = rootView.findViewById(R.id.rv_movie);
        rv_movie.setHasFixedSize(true);
        rv_movie.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void showMovies(List<Movie> movieList) {

        rv_movie.setAdapter(new MovieAdapter(getViewContext(),movieList));

      //  Toast.makeText(getViewContext(), movieList.size()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {

        Toast.makeText(getViewContext(), error+"", Toast.LENGTH_SHORT).show();
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

