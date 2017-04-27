package mx.lfa.com.rawrstudio.presenters;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Calendar;

import mx.lfa.com.rawrstudio.broadcastreceivers.NewsReceiver;
import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenPresenter;
import mx.lfa.com.rawrstudio.utils.Strings;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Ricardo Rodriguez on 4/17/2017.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private static final String FIRST_RUN = "firstRun";

    private SharedPreferences sharedPreferences = null;
    private Activity activity;
    private Intent intent;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    public SplashScreenPresenterImpl(Activity activity) {
        this.activity = activity;


        this.sharedPreferences = activity.getSharedPreferences(Strings.PREFS_NAME, Context.MODE_PRIVATE);

        boolean flag = isFirstLaunch();
        startAlertAtParticularTime();
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
     * Start alert at particular time.
     */
    @Override
    public void startAlertAtParticularTime() {
        // alarm first vibrate at 14 hrs and 40 min and repeat itself at ONE_HOUR interval

        intent = new Intent(activity, NewsReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                activity.getApplicationContext(), 280192, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 00);

        alarmManager = (AlarmManager) activity.getSystemService(ALARM_SERVICE);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_HALF_DAY, pendingIntent);

    }
}
