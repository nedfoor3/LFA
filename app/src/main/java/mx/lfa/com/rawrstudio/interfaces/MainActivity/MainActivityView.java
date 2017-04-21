package mx.lfa.com.rawrstudio.interfaces.MainActivity;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public interface MainActivityView {
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Hide progress.
     */
    void hideProgress();

    /**
     * Hide progress swip container.
     */
    void hideProgressSwipContainer();

    /**
     * Show timer.
     */
    void showTimer();

    /**
     * Hide timer.
     */
    void hideTimer();

    /**
     * Show cant load error.
     */
    void showCantLoadError();

    /**
     * Hide cant load error.
     */
    void hideCantLoadError();

}
