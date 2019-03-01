package com.br.diegolms.phoebus.data.di;

import com.br.diegolms.phoebus.data.service.ApiRequest;

import dagger.Module;
import dagger.Provides;

@Module public class DataModule {

    @Provides
    ApiRequest providesApiRequest() {
        return new ApiRequest();
    }
}
