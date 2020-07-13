package com.bp.batman.details;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bp.batman.R;
import com.bp.batman.base.BaseFragment;
import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieRepository;


public class DetailsFragment extends BaseFragment implements DetailsContract.View{

    DetailsContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle= getArguments();
        assert bundle != null;
        String imdbId= bundle.getString("imdbId");

        presenter=new DetailsPresenter(new MovieRepository(),imdbId);

       // Toast.makeText(getContext(), imdbId, Toast.LENGTH_SHORT).show();


        }

    @Override
    public int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    public void setUpViews() {

    }


    @Override
    public void showDetails(Movie movie) {
        Toast.makeText(getViewContext(), movie.getTitle()+"", Toast.LENGTH_SHORT).show();
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

