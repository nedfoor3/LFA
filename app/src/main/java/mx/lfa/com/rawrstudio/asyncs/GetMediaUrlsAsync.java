package mx.lfa.com.rawrstudio.asyncs;

import android.os.AsyncTask;
import android.util.Log;

import mx.lfa.com.rawrstudio.adapters.ImageByUrlAdapter;
import mx.lfa.com.rawrstudio.interactors.NewsActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityInteractor;
import mx.lfa.com.rawrstudio.views.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public class GetMediaUrlsAsync extends AsyncTask<Void, Integer, Boolean> {

    private NewsActivity activity;
    private int mIdMedia;
    private String mUrlFeature;

    private String[] imageURls;

    /**
     * Instantiates a new Get media urls async.
     *
     * @param activity the activity
     * @param idMedia  the id media
     */
    public GetMediaUrlsAsync(NewsActivity activity, int idMedia, String urlFeature) {
        this.activity = activity;
        this.mIdMedia = idMedia;
        this.mUrlFeature = urlFeature;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        NewsActivityInteractor newsActivityInteractor = new NewsActivityInteractorImpl(activity);
        activity.setListMedia(newsActivityInteractor.getUrlsMedia(mIdMedia));

        if (activity.getListMedia() != null) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);


        if (activity.getListMedia() != null) {

            imageURls = new String[activity.getListMedia().size()];

            for (int i = 0; i < activity.getListMedia().size(); i++) {

                Log.v("URL", activity.getListMedia().get(i).getGuid().getRendered());
                imageURls[i] = activity.getListMedia().get(i).getGuid().getRendered();
            }

        } else {
            imageURls = new String[]{mUrlFeature};
        }

        activity.getPagerGallery().setAdapter(new ImageByUrlAdapter(activity, imageURls));
        activity.getIndicator().setViewPager(activity.getPagerGallery());
    }


}
