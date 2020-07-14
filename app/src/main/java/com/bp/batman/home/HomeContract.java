package com.bp.batman.home;

import com.bp.batman.base.BasePresenter;
import com.bp.batman.base.BaseView;
import com.bp.batman.data.Movie;

import java.util.List;

public interface HomeContract {

    interface View extends BaseView{
        void showMovies(List<Movie> movieList);
        void showError(String error);
    }

    interface Presenter extends BasePresenter<View>{
        void getMoviesList();
        void saveMovieList(List<Movie> movieList);
    }

}
