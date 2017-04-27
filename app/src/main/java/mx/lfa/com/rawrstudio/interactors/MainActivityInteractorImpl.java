package mx.lfa.com.rawrstudio.interactors;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mx.lfa.com.rawrstudio.dao.RetrofitNewsDao;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityInteractor;
import mx.lfa.com.rawrstudio.models.News;
import mx.lfa.com.rawrstudio.utils.Strings;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */

public class MainActivityInteractorImpl implements MainActivityInteractor {

    private static final int HTTP_SUCCESS_RESPONCE = 200;
    private SharedPreferences sharedPreferences;

    private Context context;

    public MainActivityInteractorImpl(Context cont) {
        this.context = cont;

        this.sharedPreferences = cont.getSharedPreferences(Strings.PREFS_NAME, cont.MODE_PRIVATE);
    }

    /**
     * Gets recent news.
     *
     * @return the recent news
     */
    @Override
    public List<News> getRecentNews() {
        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl(Strings.BASE_NEWS_API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitNewsDao retrofitNewsDaoService = retrofit.create(RetrofitNewsDao.class);

        Call<List<News>> call = retrofitNewsDaoService.getRecentNewsList();

        List<News> mListNews = new ArrayList<>();

        try {

            if (HTTP_SUCCESS_RESPONCE == call.execute().code()) {

                Call<List<News>> mCall = call.clone();
                mListNews = mCall.execute().body();

                sharedPreferences.edit().putString(Strings.PREFS_NEWS_LAST_DATE, mListNews.get(0).getDate()).commit();

            } else {
                mListNews = null;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return mListNews;

    }

    /**
     * Gets old news.
     *
     * @return the old news
     */
    @Override
    public List<News> getOldNews(int page) {

        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl(Strings.BASE_NEWS_API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitNewsDao retrofitNewsDaoService = retrofit.create(RetrofitNewsDao.class);
        Call<List<News>> call = retrofitNewsDaoService.getOldNews(page);

        List<News> mListNews = new ArrayList<>();

        try {

            if (HTTP_SUCCESS_RESPONCE == call.execute().code()) {

                Call<List<News>> mCall = call.clone();
                mListNews = mCall.execute().body();
            } else {
                mListNews = null;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return mListNews;
    }
}
