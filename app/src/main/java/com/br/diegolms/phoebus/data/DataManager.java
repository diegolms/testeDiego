package com.br.diegolms.phoebus.data;

import com.br.diegolms.phoebus.common.model.Marvel;
import com.br.diegolms.phoebus.data.di.DaggerDataComponent;
import com.br.diegolms.phoebus.data.service.ApiRequest;
import com.br.diegolms.phoebus.util.Constants;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataManager {

    @Inject
    ApiRequest apiRequest;

    public DataManager() {

        DaggerDataComponent.create().inject(this);

    }

    public Observable<Marvel> getMarvel(){
        return apiRequest.get().getComics(Constants.TS, Constants.APIKEY, Constants.HASH);
    }





}