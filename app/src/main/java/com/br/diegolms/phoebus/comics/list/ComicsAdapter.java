package com.br.diegolms.phoebus.comics.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.diegolms.phoebus.R;
import com.br.diegolms.phoebus.base.BaseViewHolder;
import com.br.diegolms.phoebus.common.model.Result;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ComicsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Result> resultList = new ArrayList<>();


    public void addComics(List<Result> list) {
        resultList.clear();
        resultList.addAll(list);
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comics_list_item, parent, false);
        return new ComicViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        Result result = resultList.get(position);
        holder.bind(result);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public void clear() {
        resultList.removeAll(resultList);
        notifyDataSetChanged();
    }

    public ArrayList<Result> getList() {
        return resultList;
    }
}
