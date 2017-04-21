package mx.lfa.com.rawrstudio.interfaces.NewsActivity;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public interface NewsActivityView {

    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Hide progress.
     */
    void hideProgress();

    /**
     * Show article.
     */
    void showArticle();

    /**
     * Hide article.
     */
    void hideArticle();

    /**
     * Show cant load error.
     */
    void showCantLoadError();

    /**
     * Hide cant load error.
     */
    void hideCantLoadError();

    /**
     * Sets title.
     */
    void setTitle();

    /**
     * Sets text.
     */
    void setText();

    /**
     * Sets date.
     *
     * @param customDate the custom date
     */
    void setDate(String customDate);

}
