package mx.lfa.com.rawrstudio.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class NewsWithoutImageFeatureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;

    public NewsWithoutImageFeatureViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.news_title);
        itemView.setOnClickListener(this);
    }

    public void setTitle(String title) {
        this.title.setText(title.toUpperCase());
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(itemView.getContext(), "hola", Toast.LENGTH_SHORT).show();
    }
}
