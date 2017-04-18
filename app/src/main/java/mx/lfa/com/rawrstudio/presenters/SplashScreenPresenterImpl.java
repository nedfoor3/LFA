package mx.lfa.com.rawrstudio.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenPresenter;

/**
 * Created by Ricardo Rodriguez on 4/17/2017.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private static final String FIRST_RUN = "firstRun";
    private static final String PREFS_NAME = "mx.lfa";
    private SharedPreferences sharedPreferences = null;
    private Activity activity;
    boolean firstLaunch = false;

    public SplashScreenPresenterImpl(Activity activity) {
        this.activity = activity;

        this. sharedPreferences = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        boolean flag = isFirstLaunch();
        Toast.makeText(activity, "Flag: " + flag, Toast.LENGTH_SHORT).show();
    }

    /**
     * Is first launch boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isFirstLaunch() {
        
        if (sharedPreferences.getBoolean(FIRST_RUN, true)){
            sharedPreferences.edit().putBoolean(FIRST_RUN, false).commit();
            return true;
        }
        else {
            return false;
        }


    }

    /**
     * Push notification settings.
     */
    @Override
    public void pushNotificationSettings() {

    }
}
