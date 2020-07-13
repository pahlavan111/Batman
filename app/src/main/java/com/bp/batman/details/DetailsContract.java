package com.bp.batman.details;

import com.bp.batman.base.BasePresenter;
import com.bp.batman.base.BaseView;
import com.bp.batman.data.Movie;

public interface DetailsContract {

    interface View extends BaseView{
        void showDetails(Movie movie);
        void showError(String e);
    }

    interface Presenter extends BasePresenter<View>{
        void getMovieDetails(String imdbID);
    }
}
