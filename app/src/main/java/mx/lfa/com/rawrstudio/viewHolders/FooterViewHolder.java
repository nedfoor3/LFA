package mx.lfa.com.rawrstudio.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Ricardo Rodriguez on 4/16/2017.
 */

public class FooterViewHolder extends RecyclerView.ViewHolder {

    private ProgressBar progressBar;


    public FooterViewHolder(View itemView) {
        super(itemView);
        this.progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
