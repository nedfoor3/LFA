package mx.lfa.com.rawrstudio.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenPresenter;
import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenView;
import mx.lfa.com.rawrstudio.presenters.SplashScreenPresenterImpl;

/**
 * The type Splash screen activity.
 */
public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //splash screen se usa para cargar datos iniciale, manejar con cuidado

        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenterImpl(this);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();

    }

    /**
     * On finish load preferences.
     */
    @Override
    public void onFinishLoadPreferences() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }

}
