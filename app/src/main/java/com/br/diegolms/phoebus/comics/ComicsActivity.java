package com.br.diegolms.phoebus.comics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.br.diegolms.phoebus.R;
import com.br.diegolms.phoebus.comicdetail.ComicDetailActivity;
import com.br.diegolms.phoebus.comics.core.ComicsContract;
import com.br.diegolms.phoebus.comics.di.ComicsModule;
import com.br.diegolms.phoebus.comics.di.DaggerComicsComponent;
import com.br.diegolms.phoebus.comics.list.ComicsAdapter;
import com.br.diegolms.phoebus.common.model.Marvel;
import com.br.diegolms.phoebus.common.model.Result;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class ComicsActivity extends AppCompatActivity implements ComicsContract.View {

    @BindView(R.id.comics_list)
    RecyclerView recyclerView;

    @BindView(R.id.comics_shimmer_content)
    LinearLayout shimmerContent;
    @BindView(R.id.comics_shimmer_item_1)
    ShimmerFrameLayout shimmerItem1;
    @BindView(R.id.comics_shimmer_item_2)
    ShimmerFrameLayout shimmerItem2;
    @BindView(R.id.comics_shimmer_item_3)
    ShimmerFrameLayout shimmerItem3;
    @BindView(R.id.comics_shimmer_item_4)
    ShimmerFrameLayout shimmerItem4;

    @Inject
    ComicsContract.Presenter comicsPresenter;

    private ComicsAdapter comicsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        DaggerComicsComponent.builder().comicsModule(new ComicsModule(this)).build().
                inject(this);

        initShimmer();
        comicsAdapter = new ComicsAdapter();
        setRecyclerView();

        comicsPresenter.onCreate();

    }

    private void setRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(comicsAdapter);
    }

    @Override
    public void showComicList(Marvel marvel) {
        comicsAdapter.addComics(marvel.getData().getResults());
        comicsAdapter.notifyDataSetChanged();
        stopShimmer();
    }


    @Override
    public Observable<Integer> itemClicks() {
        return comicsAdapter.observeClicks();
    }

    @Override
    public void goToComicDetailsActivity(Result result, int position) {
        Intent in = new Intent(this, ComicDetailActivity.class);
        //in.putExtra("comic", (Serializable) result);
        startActivity(in);
    }

    private void initShimmer() {
        recyclerView.setVisibility(View.GONE);
        shimmerContent.setVisibility(View.VISIBLE);
        shimmerItem1.startShimmer();
        shimmerItem2.startShimmer();
        shimmerItem3.startShimmer();
        shimmerItem4.startShimmer();
    }

    private void stopShimmer() {
        shimmerItem1.stopShimmer();
        shimmerItem2.stopShimmer();
        shimmerItem3.stopShimmer();
        shimmerItem4.stopShimmer();
        shimmerContent.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


}
