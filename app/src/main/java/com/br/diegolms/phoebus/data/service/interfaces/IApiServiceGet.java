package com.br.diegolms.phoebus.data.service.interfaces;

import com.br.diegolms.phoebus.common.model.Marvel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiServiceGet {

    @GET("comics")
    Observable<Marvel> getComics(@Query("ts") Integer ts, @Query("apikey") String apikey, @Query("hash") String hash);
}