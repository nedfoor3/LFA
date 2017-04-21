package mx.lfa.com.rawrstudio.asyncs;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.adapters.NewsAdapter;
import mx.lfa.com.rawrstudio.interactors.MainActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityInteractor;
import mx.lfa.com.rawrstudio.models.News;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class GetNewsSwipContainerAsync extends AsyncTask<Void, Integer, Boolean> {

    private MainActivity mView;
   // private List<News> mListNews;
    private RecyclerView mRecyclerView;

    public GetNewsSwipContainerAsync(MainActivity view, RecyclerView RecyclerView) {
        this.mView = view;
        this.mRecyclerView = RecyclerView;
    }

    @Override
    protected void onPreExecute() {
        //mView.showProgress();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        MainActivityInteractor interactor = new MainActivityInteractorImpl(mView);

        mView.setLisNews(new ArrayList<News>());
        mView.setLisNews(interactor.getRecentNews());
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        mView.setNewsAdapter(new NewsAdapter(mView.getLisNews()));

        mRecyclerView.setAdapter(mView.getNewsAdapter());

        mView.hideProgressSwipContainer();
        //aqui devera ir si existe o no algo xD
    }

}