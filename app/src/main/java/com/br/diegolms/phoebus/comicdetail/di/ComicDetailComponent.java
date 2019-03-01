package com.br.diegolms.phoebus.comicdetail.di;

import com.br.diegolms.phoebus.comicdetail.core.ComicDetailContract;

import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { ComicDetailModule.class })
public interface ComicDetailComponent {
    void inject(ComicDetailContract comicDetailActivity);
}
