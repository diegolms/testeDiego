package com.br.diegolms.phoebus.comicdetail;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.br.diegolms.phoebus.R;
import com.br.diegolms.phoebus.comicdetail.core.ComicDetailContract;
import com.br.diegolms.phoebus.common.model.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import javax.inject.Inject;

public class ComicDetailActivity extends AppCompatActivity implements ComicDetailContract.View {

    @BindView(R.id.comic_detail_bg_poster) ImageView bgPoster;
    @Inject ComicDetailContract.Presenter comicDetailPresenter;

    private Result result;

    private String path;
    private String extension;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportPostponeEnterTransition();

        setContentView(R.layout.activity_comic_detail);
        ButterKnife.bind(this);

        path =  getIntent().getExtras().getString("thumbnail");
        extension =  getIntent().getExtras().getString("extension");
        showComicInfo();
    }

    private void showComicInfo() {

            String url = path+"/standard_medium."+extension;

            Glide.with(this)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(bgPoster);
    }



    @Override protected void onDestroy() {
        super.onDestroy();
        comicDetailPresenter.onDestroy();
    }
}
