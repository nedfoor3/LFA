package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;

public class TazonPlayByPlay extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.marcador_mayas)
    TextView marcadorMayas;
    @BindView(R.id.marcador_dinos)
    TextView marcadorDinos;
    @BindView(R.id.recycler_play_by_play)
    RecyclerView recyclerPlayByPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_tazon_play_by_play);
        ButterKnife.bind(this);

        setToolbarValues();
    }

    //@Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
