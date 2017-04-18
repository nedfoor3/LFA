package mx.lfa.com.rawrstudio.interfaces.MainActivity;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public interface MainActivityPresenter {

    /**
     * Load news.
     */
    void loadNews();

    /**
     * Load news swip container.
     */
    void loadNewsSwipContainer();

    /**
     * Load old news.
     *
     * @param counterPage the counter page
     */
    void loadOldNews(int counterPage);

    /**
     * Sets countdown.
     */
    void setCountdown();

}
