package com.br.diegolms.phoebus.comics.di;

import com.br.diegolms.phoebus.comics.ComicsActivity;

import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { ComicsModule.class })
public interface ComicsComponent {
    void inject(ComicsActivity comicsActivity);
}
