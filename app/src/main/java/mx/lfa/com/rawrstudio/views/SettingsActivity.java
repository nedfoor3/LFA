package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import mx.lfa.com.rawrstudio.fragments.PreferenciasFragment;

import mx.lfa.com.rawrstudio.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment())
                .commit();
    }
}
