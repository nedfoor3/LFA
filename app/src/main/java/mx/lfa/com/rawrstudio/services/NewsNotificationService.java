package mx.lfa.com.rawrstudio.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import mx.lfa.com.rawrstudio.asyncs.GetRecentNewsServiceAsync;

/**
 * Created by Ricardo Rodriguez on 4/19/2017.
 */

public class NewsNotificationService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * @param intent
     * @param startId
     * @deprecated
     */
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        GetRecentNewsServiceAsync getRecentNewsServiceAsync = new GetRecentNewsServiceAsync(getApplicationContext());

        getRecentNewsServiceAsync.execute();


    }
}
