package mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity;

/**
 * Created by Ricardo Rodriguez on 4/17/2017.
 */
public interface SplashScreenPresenter {

    /**
     * Is first launch boolean.
     *
     * @return the boolean
     */
    boolean isFirstLaunch();


    /**
     * Start alert at particular time.
     */
    void startAlertAtParticularTime();

}
