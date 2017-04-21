package mx.lfa.com.rawrstudio.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import mx.lfa.com.rawrstudio.services.NewsNotificationService;


/**
 * Created by Ricardo Rodriguez on 4/19/2017.
 */

public class NewsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        /*Toast.makeText(context, "Time Up... Now Vibrating !!!",
                Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);*/

        Intent intentService = new Intent(context, NewsNotificationService.class);
        context.startService(intentService);

    }
}
