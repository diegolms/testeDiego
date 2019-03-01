package com.br.diegolms.phoebus.comicdetail.di;


import com.br.diegolms.phoebus.comicdetail.core.ComicDetailContract;
import com.br.diegolms.phoebus.comicdetail.core.ComicDetailPresenter;
import com.br.diegolms.phoebus.data.DataManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module public class ComicDetailModule {
    private ComicDetailContract.View comicDetailView;

    public ComicDetailModule(ComicDetailContract.View viewDetail) {
        this.comicDetailView = viewDetail;
    }

    @Provides ComicDetailContract.Presenter providesComicDetailPresenter() {
        return new ComicDetailPresenter(comicDetailView, new DataManager(), new CompositeDisposable());
    }
}
