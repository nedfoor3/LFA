package mx.lfa.com.rawrstudio.viewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.utils.Strings;
import mx.lfa.com.rawrstudio.views.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private String sTitle;
    private String sFullText;
    private String sDate;
    private int idMedia;
    private ImageView mFeatureImage;
    private String urlFetatureImage;

    public NewsViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.news_title);
        mFeatureImage = (ImageView) itemView.findViewById(R.id.news_image_feature);
        itemView.setOnClickListener(this);
    }

    public void setTitle(String title) {
        this.title.setText(title.toUpperCase());
        this.sTitle = title.toUpperCase();
    }

    public void setText(String text) {
        this.sFullText = text;
    }

    public void setDate(String date) {
        this.sDate = date;
    }

    public void setIdMedia(int id) {
        this.idMedia = id;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(itemView.getContext(), NewsActivity.class);
        intent.putExtra(Strings.INTENT_NEWS_TITLE, sTitle);
        intent.putExtra(Strings.INTENT_NEWS_TEXT, sFullText);
        intent.putExtra(Strings.INTENT_NEWS_DATE, sDate);
        intent.putExtra(Strings.INTENT_NEWS_ID_MEDIA, idMedia);
        intent.putExtra(Strings.INTENT_NEWS_URL_FEAUTRE, urlFetatureImage);
        itemView.getContext().startActivity(intent);
    }

    public void setFeatureImage(String UrlFeatureImage) {
        Glide.with(itemView.getContext()).load(UrlFeatureImage).into(mFeatureImage);
        this.urlFetatureImage = UrlFeatureImage;
    }
}
