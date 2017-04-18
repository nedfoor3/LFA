package mx.lfa.com.rawrstudio.dao;

import java.util.List;

import mx.lfa.com.rawrstudio.models.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public interface RetrofitNewsDao {

    /**
     * Gets recent news list.
     *
     * @return the recent news list
     */
    @GET("posts")
    Call<List<News>> getRecentNewsList();

    @GET("posts")
    Call<List<News>> getOldNews(@Query("page") int page);
}
