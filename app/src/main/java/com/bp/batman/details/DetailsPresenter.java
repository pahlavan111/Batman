package com.bp.batman.details;

import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieDataSource;
import com.bp.batman.home.HomePresenter;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;
    private MovieDataSource movieDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private static final String API_KEY = "3e974fca";

    private  String M_ID;


    public DetailsPresenter(MovieDataSource movieDataSource,String m_ID) {
        this.movieDataSource = movieDataSource;
        this.M_ID=m_ID;

    }

    @Override
    public void getMovieDetails(String imdbID) {

        movieDataSource.getMovieDetails(imdbID,API_KEY ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Movie movie) {
                            view.showDetails(movie);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void attachView(DetailsContract.View view) {
        this.view=view;
        getMovieDetails(M_ID);
    }

    @Override
    public void detachView() {

        this.view=null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }
    }
}
