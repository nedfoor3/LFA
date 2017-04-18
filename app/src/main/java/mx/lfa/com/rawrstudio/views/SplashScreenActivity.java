package mx.lfa.com.rawrstudio.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenPresenter;
import mx.lfa.com.rawrstudio.interfaces.SplashScreenActivity.SplashScreenView;
import mx.lfa.com.rawrstudio.presenters.SplashScreenPresenterImpl;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //no se pone setContetn porque la vista se llena desde el drawable
        // setContentView(R.layout.activity_splash_screen);

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
