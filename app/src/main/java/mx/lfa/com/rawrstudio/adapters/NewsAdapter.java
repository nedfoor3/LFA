package mx.lfa.com.rawrstudio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.News;
import mx.lfa.com.rawrstudio.utils.Footer;
import mx.lfa.com.rawrstudio.viewHolders.FooterViewHolder;
import mx.lfa.com.rawrstudio.viewHolders.NewsViewHolder;
import mx.lfa.com.rawrstudio.viewHolders.NewsWithoutImageFeatureViewHolder;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<News> mListNews;

    private static final int ID_LAYOUT_WITHOUT_IMAGE_FEATURE = 0;
    private static final int ID_LAYOUT_WITH_IMAGE_FEATURE = 1;
    private static final int ID_LAYOUT_PROGRESSBAR = 99;

    private static final String CLASSNAME_FOOTER_VIEWHOLDER = "FooterViewHolder";
    private static final String CLASSNAME_WITHOUT_IMAGE_VIEWHOLDER = "NewsWithoutImageFeatureViewHolder";
    private static final String CLASSNAME_WITH_IMAGE_VIEWHOLDER = "NewsViewHolder";


    /**
     * Instantiates a new News adapter.
     *
     * @param mListNews the m list news
     */
    public NewsAdapter(List<News> mListNews) {
        this.mListNews = mListNews;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        switch (viewType){
            case ID_LAYOUT_PROGRESSBAR:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_progressbar,parent, false);
                return new FooterViewHolder(itemView);
            case ID_LAYOUT_WITHOUT_IMAGE_FEATURE:

                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_without_feature_image, parent, false);
                return new NewsWithoutImageFeatureViewHolder(itemView);
            default://ID_LAYOUT_WITH_IMAGE_FEATURE
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_basic, parent, false);
                return new NewsViewHolder(itemView);

        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String titulo;
        String text;
        String date;
        Integer id;

        if (CLASSNAME_WITHOUT_IMAGE_VIEWHOLDER.compareTo(holder.getClass().getSimpleName()) == 0){
            NewsWithoutImageFeatureViewHolder holderWithout = new NewsWithoutImageFeatureViewHolder(holder.itemView);

            titulo = mListNews.get(position).getTitle().getRendered();
            holderWithout.setTitle(titulo);
        } else if (CLASSNAME_WITH_IMAGE_VIEWHOLDER.compareTo(holder.getClass().getSimpleName())==0){
            NewsViewHolder mHolder = new NewsViewHolder(holder.itemView);

            titulo = mListNews.get(position).getTitle().getRendered();
            mHolder.setTitle(titulo);

            text = mListNews.get(position).getContent().getRendered();
            mHolder.setText(text);

            date = mListNews.get(position).getDate();
            mHolder.setDate(date);

            id = mListNews.get(position).getId();
            mHolder.setIdMedia(id);

            String urlImage = mListNews.get(position).getBetter_featured_image().getSource_url();
            mHolder.setFeatureImage(urlImage);
        }

        // FOOTHER: NOTHING TO DO



    }


    @Override
    public int getItemCount() {
        return mListNews.size();
    }


    @Override
    public int getItemViewType(int position) {
        News itemNews = mListNews.get(position);

        if (mListNews.get(position) instanceof Footer){

            return ID_LAYOUT_PROGRESSBAR;
        }else {

            if (itemNews.getBetter_featured_image() == null) {
                return ID_LAYOUT_WITHOUT_IMAGE_FEATURE;
            } else {
                return ID_LAYOUT_WITH_IMAGE_FEATURE;
            }
        }
    }

}
