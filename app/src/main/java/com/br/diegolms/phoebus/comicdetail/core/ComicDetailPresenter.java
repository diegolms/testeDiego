package com.br.diegolms.phoebus.comicdetail.core;

import com.br.diegolms.phoebus.data.DataManager;
import io.reactivex.disposables.CompositeDisposable;


public class ComicDetailPresenter implements ComicDetailContract.Presenter {

    private ComicDetailContract.View comicDetailView;
    private DataManager dataManager;

    public ComicDetailPresenter(ComicDetailContract.View movieDetailView, DataManager dataManager,
                                CompositeDisposable subs) {
        this.comicDetailView = movieDetailView;
        this.dataManager = dataManager;
    }


    @Override public void onDestroy() {
    }
}
