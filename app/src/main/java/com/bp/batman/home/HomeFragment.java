package com.bp.batman.home;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;
import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieRepository;
import java.util.List;


public class HomeFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter presenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(new MovieRepository());
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setUpViews() {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void showMovies(List<Movie> movieList) {

        Toast.makeText(getViewContext(), movieList.size()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {

        
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

