package mx.lfa.com.rawrstudio.asyncs;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.adapters.NewsAdapter;
import mx.lfa.com.rawrstudio.interactors.MainActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityInteractor;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class GetRecentNewsListAsync extends AsyncTask<Void, Integer, Boolean>{


    private MainActivity mView;
    //private List<News> mListNews;
    private RecyclerView mRecyclerView;

    public GetRecentNewsListAsync(MainActivity view, RecyclerView RecyclerView) {
        this.mView = view;
        this.mRecyclerView = RecyclerView;


    }

    @Override
    protected void onPreExecute() {
        mView.showProgress();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        MainActivityInteractor interactor = new MainActivityInteractorImpl(mView);
        mView.setLisNews(interactor.getRecentNews());
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        if (mView.getLisNews().size() > 0) {
            mView.setNewsAdapter(new NewsAdapter(mView.getLisNews()));

            mRecyclerView.setAdapter(mView.getNewsAdapter());

            mView.hideCantLoadError();
            mView.hideProgress();

        } else {
            mView.showCantLoadError();

        }

        //aqui devera ir si existe o no algo xD
    }
}
