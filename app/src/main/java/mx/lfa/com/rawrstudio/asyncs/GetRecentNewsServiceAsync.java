package mx.lfa.com.rawrstudio.asyncs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
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

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Ricardo Rodriguez on 4/19/2017.
 */
public class GetRecentNewsServiceAsync extends AsyncTask<Void, Integer, Boolean> {

    private List<News> mListNews;
    private Context context;
    private SharedPreferences sharedPreferences = null;
    private String lastNewsDate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private int newsCounter = 0;
    Date lastDate;
    Date newDate;

    /**
     * Instantiates a new Get recent news service async.
     *
     * @param applicationContext the application context
     */
    public GetRecentNewsServiceAsync(Context applicationContext) {
        this.context = applicationContext;
        this.sharedPreferences = context.getSharedPreferences(Strings.PREFS_NAME, 0);


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        newsCounter = 0;
        lastNewsDate = sharedPreferences.getString(Strings.PREFS_NEWS_LAST_DATE, "");
        try {
            lastDate = sdf.parse(lastNewsDate);

            Log.v("Fecha guardada;", "" + lastDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        MainActivityInteractor interactor = new MainActivityInteractorImpl(context);
        mListNews = interactor.getRecentNews();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

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

        Intent intent = new Intent(context, SplashScreenActivity.class);
        // use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n = new Notification.Builder(context)
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.push_notificatio_subtitle_first) + " " + num + " " + context.getString(R.string.push_notificatio_subtitle_second))
                .setSmallIcon(R.drawable.ic_lfa_notificacion)
                .setContentIntent(pIntent)
                .setAutoCancel(true).setSound(alarmSound)
                .build();


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);

    }
}
