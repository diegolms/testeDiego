package com.br.diegolms.phoebus.comics.core;

import com.br.diegolms.phoebus.base.BasePresenter;
import com.br.diegolms.phoebus.common.model.Marvel;
import com.br.diegolms.phoebus.common.model.Result;

import io.reactivex.Observable;

public interface ComicsContract {

    interface View {
        void showComicList(Marvel marvel);
        Observable<Integer> itemClicks();
        void goToComicDetailsActivity(Result result, int position);
    }

    interface Presenter extends BasePresenter {
        void onCreate();
    }
}
