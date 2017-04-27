package mx.lfa.com.rawrstudio.presenters;

import java.text.ParseException;

import mx.lfa.com.rawrstudio.asyncs.GetMediaUrlsAsync;
import mx.lfa.com.rawrstudio.interactors.NewsActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityInteractor;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityPresenter;
import mx.lfa.com.rawrstudio.views.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public class NewsActivityPresenterImpl implements NewsActivityPresenter {

    private NewsActivity view;
    private int idMedia;
    private String mUrlFeature;
    private NewsActivityInteractor newsActivityInteractor;
    private String dateCustom;

    /**
     * Instantiates a new News activity presenter.
     *
     * @param activity the activity
     * @param date
     */
    public NewsActivityPresenterImpl(NewsActivity activity, int idMedia, String urlFeature, String date) {
        this.idMedia = idMedia;
        this.view = activity;
        this.mUrlFeature = urlFeature;
        this.newsActivityInteractor = new NewsActivityInteractorImpl(activity);


        try {
            dateCustom = newsActivityInteractor.getCustomDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
            view.setDate(dateCustom);
            view.showArticle();
            view.hideProgress();

            GetMediaUrlsAsync getMediaUrlsAsync = new GetMediaUrlsAsync(view, idMedia, mUrlFeature);

            //probar a que regrese del asynctask
            getMediaUrlsAsync.execute();
        }

    }
}
