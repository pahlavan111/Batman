package com.bp.batman.home;

import android.util.Log;
import android.widget.Toast;

import com.bp.batman.base.BasePresenter;
import com.bp.batman.data.Movie;
import com.bp.batman.data.MovieDataSource;
import com.bp.batman.data.ResponseMpdel;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//import io.reactivex.SingleObserver;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private MovieDataSource movieDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private static final String API_KEY = "3e974fca";
    private static final String SEARCH_KEY = "batman";


    public HomePresenter(MovieDataSource movieDataSource) {
        this.movieDataSource = movieDataSource;
    }

    @Override
    public void getMoviesList() {


        movieDataSource.getMy(SEARCH_KEY, API_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseMpdel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(ResponseMpdel responseMpdel) {

                        ResponseMpdel responseMpdel1 = responseMpdel;
                        Toast.makeText(view.getViewContext(), responseMpdel1.getTotalResults() + "", Toast.LENGTH_SHORT).show();

                        List<Movie> movieList = responseMpdel1.getSearch();
                        for (Movie m :
                                movieList) {

                            Log.d("beh",m.getTitle()+"\n");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void attachView(HomeContract.View view) {

        this.view = view;
        getMoviesList();
    }

    @Override
    public void detachView() {


        this.view = null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }
    }
}
