package mx.lfa.com.rawrstudio.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private ImageView mFeatureImage;

    public NewsViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.news_title);
        mFeatureImage = (ImageView) itemView.findViewById(R.id.news_image_feature);
        itemView.setOnClickListener(this);
    }

    public void setTitle(String title) {
        this.title.setText(title.toUpperCase());
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(itemView.getContext(), "eso", Toast.LENGTH_SHORT).show();
    }

    public void setFeatureImage(String UrlFeatureImage) {
        Glide.with(itemView.getContext()).load(UrlFeatureImage).into(mFeatureImage);
    }
}
