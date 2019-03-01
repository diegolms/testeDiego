package com.br.diegolms.phoebus.comics.di;


import com.br.diegolms.phoebus.comics.core.ComicsContract;
import com.br.diegolms.phoebus.comics.core.ComicsPresenter;
import com.br.diegolms.phoebus.data.DataManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module public class ComicsModule {

    private ComicsContract.View comicsView;

    public ComicsModule(ComicsContract.View view) {
        this.comicsView = view;
    }

    @Provides ComicsContract.Presenter providesComicsPresent() {
        return new ComicsPresenter(this.comicsView, new DataManager(), new CompositeDisposable());
    }
}
