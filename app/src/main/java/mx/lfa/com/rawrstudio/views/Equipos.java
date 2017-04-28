package mx.lfa.com.rawrstudio.views;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interfaces.Menu.ActionbarView;
import mx.lfa.com.rawrstudio.presenters.MenuPresenterImpl;

public class Equipos extends AppCompatActivity implements ActionbarView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.header_condors)
    ImageButton headerCondors;
    @BindView(R.id.header_dinos)
    ImageButton headerDinos;
    @BindView(R.id.header_eagles)
    ImageButton headerEagles;
    @BindView(R.id.header_fundidores)
    ImageButton headerFundidores;
    @BindView(R.id.header_mayas)
    ImageButton headerMayas;
    @BindView(R.id.header_raptors)
    ImageButton headerRaptors;
    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayoutMain;
    @BindView(R.id.lateral_menu)
    NavigationView lateralMenu;
    private MenuPresenterImpl mMenuPresenter;
    private DatabaseReference mDadabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_equipos);
        ButterKnife.bind(this);
        // Toolbar and Menu
        ActionbarView actionbarView = this;
        actionbarView.setToolbarValues();
        mMenuPresenter = new MenuPresenterImpl(this);
        mMenuPresenter.onClickOptionItemMenu(lateralMenu, drawerLayoutMain);

        //iniGUIEquipos();
        iniListenersEquipos();
    }

    /*public void iniGUIEquipos() {
        btnCondors = (ImageButton) findViewById(R.id.header_condors);
        btnDinos = (ImageButton) findViewById(R.id.header_dinos);
        btnEagles = (ImageButton) findViewById(R.id.header_eagles);
        btnFundidores = (ImageButton) findViewById(R.id.header_fundidores);
        btnMayas = (ImageButton) findViewById(R.id.header_mayas);
        btnRaptors = (ImageButton) findViewById(R.id.header_raptors);
    }*/

    public void iniListenersEquipos() {
        mDadabaseReference = FirebaseDatabase.getInstance().getReference().child("2017/equipo");


        headerCondors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Condors");
                intentCondors.putExtra("ganados", "2");
                intentCondors.putExtra("perdidos", "5");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });

        headerDinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Dinos");
                intentCondors.putExtra("ganados", "2");
                intentCondors.putExtra("perdidos", "5");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });

        headerEagles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Eagles");
                intentCondors.putExtra("ganados", "4");
                intentCondors.putExtra("perdidos", "3");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });

        headerFundidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Fundidores");
                intentCondors.putExtra("ganados", "2");
                intentCondors.putExtra("perdidos", "5");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });

        headerMayas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Mayas");
                intentCondors.putExtra("ganados", "6");
                intentCondors.putExtra("perdidos", "1");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });

        headerRaptors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Raptors");
                intentCondors.putExtra("ganados", "5");
                intentCondors.putExtra("perdidos", "2");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });
    }

    @Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayoutMain.openDrawer(GravityCompat.START);
                return true;
            //...
        }
        return super.onOptionsItemSelected(item);
    }
}
