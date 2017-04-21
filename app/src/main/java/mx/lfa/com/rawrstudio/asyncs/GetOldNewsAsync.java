package mx.lfa.com.rawrstudio.asyncs;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.interactors.MainActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityInteractor;
import mx.lfa.com.rawrstudio.models.News;

/**
 * Created by Ricardo Rodriguez on 4/16/2017.
 */
public class GetOldNewsAsync extends AsyncTask<Void, Integer, Boolean> {

    private MainActivity mView;
    private List<News> mListNews;
    private RecyclerView mRecyclerView;
    private int page;

    public GetOldNewsAsync(MainActivity View, RecyclerView RecyclerView, int counterPage) {
        this.mView = View;
        this.mRecyclerView = RecyclerView;
        this.page = counterPage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        MainActivityInteractor mainActivityInteractor = new MainActivityInteractorImpl(mView);

        mListNews = mainActivityInteractor.getOldNews(this.page);

        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        final int size = mListNews.size();

        mView.getLisNews().remove(mView.getLisNews().size() - 1);

        mView.getLisNews().addAll(mListNews);

        mRecyclerView.getAdapter().notifyItemRangeChanged(size - 1, mView.getLisNews().size() -size);

    }
}
