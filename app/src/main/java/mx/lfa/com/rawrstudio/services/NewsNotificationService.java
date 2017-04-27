package mx.lfa.com.rawrstudio.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interactors.MainActivityInteractorImpl;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityInteractor;
import mx.lfa.com.rawrstudio.models.News;
import mx.lfa.com.rawrstudio.utils.Strings;
import mx.lfa.com.rawrstudio.views.SplashScreenActivity;

/**
 * Created by Ricardo Rodriguez on 4/19/2017.
 */

public class NewsNotificationService extends IntentService {
    private List<News> mListNews;
    private SharedPreferences sharedPreferences = null;
    private String lastNewsDate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private int newsCounter = 0;
    Date lastDate;
    Date newDate;

    public NewsNotificationService() {
        super("NewsNotificationService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        /*GetRecentNewsServiceAsync getRecentNewsServiceAsync = new GetRecentNewsServiceAsync(getApplicationContext());
hay que borrar clase getrecentnewsserviceasync, ya no se ocupa
        getRecentNewsServiceAsync.execute();*/
        this.sharedPreferences = this.getSharedPreferences(Strings.PREFS_NAME, 0);
        MainActivityInteractor interactor = new MainActivityInteractorImpl(getApplicationContext());
        mListNews = interactor.getRecentNews();


        newsCounter = 0;
        lastNewsDate = sharedPreferences.getString(Strings.PREFS_NEWS_LAST_DATE, "");
        try {
            lastDate = sdf.parse(lastNewsDate);

            Log.v("Fecha guardada;", "" + lastDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if ((!lastNewsDate.isEmpty()) && mListNews.size() > 0 && isNewsAvailable()) {
            launchPushNotification();
        }
    }


    private boolean isNewsAvailable() {

        for (int i = 0; i < mListNews.size(); i++) {

            try {
                newDate = sdf.parse(mListNews.get(i).getDate());

                if (lastDate.before(newDate)) {
                    newsCounter++;
                    Log.v("ES: ", "mayor");
                } else {
                    Log.v("ES:", "Menor");
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return newsCounter > 0 ? true : false;
    }

    private void launchPushNotification() {

        // prepare intent which is triggered if the
        // notification is selected

        String num = "1";

        if (newsCounter > 1) {
            num = "1+";
        }

        Intent intent = new Intent(this, SplashScreenActivity.class);
        // use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n = new Notification.Builder(this)
                .setContentTitle(this.getString(R.string.app_name))
                .setContentText(this.getString(R.string.push_notificatio_subtitle_first) + " " + num + " " + this.getString(R.string.push_notificatio_subtitle_second))
                .setSmallIcon(R.drawable.ic_lfa_notificacion)
                .setContentIntent(pIntent)
                .setAutoCancel(true).setSound(alarmSound)
                .build();


        NotificationManager notificationManager =
                (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);

    }

}
