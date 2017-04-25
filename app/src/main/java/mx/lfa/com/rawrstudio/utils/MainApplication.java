package mx.lfa.com.rawrstudio.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ricardo Rodriguez on 4/23/2017.
 */

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "es"));
    }


}