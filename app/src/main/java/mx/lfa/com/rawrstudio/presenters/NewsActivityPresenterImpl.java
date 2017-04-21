package mx.lfa.com.rawrstudio.presenters;

import mx.lfa.com.rawrstudio.asyncs.GetMediaUrlsAsync;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityPresenter;
import mx.lfa.com.rawrstudio.views.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public class NewsActivityPresenterImpl implements NewsActivityPresenter {

    private NewsActivity view;
    private int idMedia;
    private String mUrlFeature;

    /**
     * Instantiates a new News activity presenter.
     *
     * @param activity the activity
     */
    public NewsActivityPresenterImpl(NewsActivity activity, int idMedia, String urlFeature) {
        this.idMedia = idMedia;
        this.view = activity;
        this.mUrlFeature = urlFeature;
    }


    /**
     * Load article.
     */
    @Override
    public void loadArticle() {

        if (view != null) {
            view.showProgress();
            view.setTitle();
            view.setText();
            view.showArticle();
            view.hideProgress();

            GetMediaUrlsAsync getMediaUrlsAsync = new GetMediaUrlsAsync(view, idMedia, mUrlFeature);

            //probar a que regrese del asynctask
            getMediaUrlsAsync.execute();
        }

    }
}
