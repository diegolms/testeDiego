package com.br.diegolms.phoebus.data.service;

import com.br.diegolms.phoebus.data.service.interfaces.IApiRequests;
import com.br.diegolms.phoebus.data.service.interfaces.IApiServiceGet;
import com.br.diegolms.phoebus.util.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequest implements IApiRequests {

    private Retrofit retrofit;

    public ApiRequest() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

    @Override public IApiServiceGet get() {
        return retrofit.create(IApiServiceGet.class);
    }
}
