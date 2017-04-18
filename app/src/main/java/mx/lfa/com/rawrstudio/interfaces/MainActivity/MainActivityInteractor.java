package mx.lfa.com.rawrstudio.interfaces.MainActivity;

import java.util.List;

import mx.lfa.com.rawrstudio.models.News;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public interface MainActivityInteractor {

    /**
     * Gets recent news.
     *
     * @return the recent news
     */
    List<News> getRecentNews();

    /**
     * Gets old news.
     *
     * @return the old news
     */
    List<News> getOldNews(int page);

}
