package com.br.diegolms.phoebus;

import android.app.Application;
import android.content.Context;

public class MarvelComicsApp extends Application {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}