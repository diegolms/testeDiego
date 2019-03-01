package com.br.diegolms.phoebus.comics.core;

import android.util.Log;

import com.br.diegolms.phoebus.common.model.Marvel;
import com.br.diegolms.phoebus.common.model.Result;
import com.br.diegolms.phoebus.data.DataManager;
import com.br.diegolms.phoebus.util.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ComicsPresenter implements ComicsContract.Presenter {

    private ComicsContract.View comicsView;

    DataManager dataManager;
    private List<Result> comicsList;

    CompositeDisposable subscriptions;

    public ComicsPresenter(ComicsContract.View view, DataManager dataManager,
                           CompositeDisposable subs) {
        this.comicsView = view;
        this.dataManager = dataManager;
        this.comicsList = new ArrayList<>();
        this.subscriptions = subs;
    }

    @Override
    public void onCreate() {
        subscriptions.add(respondToClick());
        loadComicsDiscoverList();
    }

    private void loadComicsDiscoverList() {
        comicsList.removeAll(comicsList);
        loadComicDiscover();
    }

    private void loadComicDiscover() {

        Observable<Marvel> marvelObservable;
        marvelObservable = dataManager.getMarvel();

        marvelObservable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }

    private Disposable respondToClick() {
        return comicsView.itemClicks().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                comicsView.goToComicDetailsActivity(comicsList.get(integer), integer);
            }
        });
    }

    @Override
    public void onDestroy() {
        subscriptions.clear();
    }

    private void handleResults(Marvel marvel) {
        comicsView.showComicList(marvel);
        comicsList.addAll(marvel.getData().getResults());
    }

    private void handleError(Throwable t) {
        Log.d(Constants.TAG, t.getMessage());
    }

}
