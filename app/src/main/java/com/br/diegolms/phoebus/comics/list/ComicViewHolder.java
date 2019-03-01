package com.br.diegolms.phoebus.comics.list;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.br.diegolms.phoebus.R;
import com.br.diegolms.phoebus.base.BaseViewHolder;
import com.br.diegolms.phoebus.common.model.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import io.reactivex.subjects.PublishSubject;

public class ComicViewHolder extends BaseViewHolder {

    View view;

    @BindView(R.id.comics_list_item_poster) ImageView poster;
    @BindView(R.id.comics_list_item_card) CardView cardView;
    @BindView(R.id.comics_list_item_rating) TextView rating;
    @BindView(R.id.comics_list_item_ratingBar) RatingBar ratingBar;
    @BindView(R.id.comics_list_item_title) TextView title;

    public ComicViewHolder(View itemView, final PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                clickSubject.onNext(getAdapterPosition());
            }
        });
    }

    @Override public void bind(Object object) {
        Result result = (Result) object;
        title.setText(result.getTitle());
        rating.setText(result.getTitle());
        ratingBar.setRating(2);
        String url = result.getThumbnail().getPath()+"/standard_medium."+result.getThumbnail().getExtension();
        Glide.with(view.getContext())
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(poster);

    }
}
