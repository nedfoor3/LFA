package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.adapters.DetailsTeamPagerAdapter;

public class DetalleEquipos extends AppCompatActivity {

    @BindView(R.id.tv_equipo_en_toolbar)
    TextView tvEquipoEnToolbar;
    @BindView(R.id.record_equipo_en_toolbar)
    TextView recordEquipoEnToolbar;
    @BindView(R.id.logo_equipo_en_toolbar)
    ImageView logoEquipoEnToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_datos_complementarios)
    ViewPager viewPagerDatosComplementarios;
    @BindView(R.id.activity_teams_detail)
    CoordinatorLayout activityTeamsDetail;

    private PagerAdapter adapter;

    /*Nombre Equipo Static*/
    private final static String NOMBRE_EQUIPO = "nombreEquipo";
    /*Partidos Ganados Static*/
    private final static String PARTIDOS_GANADOS = "ganados";
    /*Partidos Perdidos Static*/
    private final static String PARTIDOS_PERDIDOS = "perdidos";
    /*Partidos Empatados Static*/
    private final static String PARTIDOS_EMPATADOS = "empatados";
    /*Nombre Equipo*/
    private String nombreEquipo;
    /*Record Equipo*/
    private String recordEquipo;
    /*Ganados*/
    private String ganados;
    /*Perdidos*/
    private String perdidos;
    /*Empatados*/
    private String empatados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_equipos);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));

        instanciarElementos();

        cargaDetallesEquipo();
    }

    private void instanciarElementos() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Bundle extras = getIntent().getExtras();

        this.nombreEquipo = extras.getString(NOMBRE_EQUIPO);
        this.ganados = extras.getString(PARTIDOS_GANADOS);
        this.perdidos = extras.getString(PARTIDOS_PERDIDOS);
        this.empatados = extras.getString(PARTIDOS_EMPATADOS);

        adapter = new DetailsTeamPagerAdapter(getSupportFragmentManager(), this, this.nombreEquipo);

        viewPagerDatosComplementarios.setAdapter(adapter);

        viewPagerDatosComplementarios.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new
                                                   TabLayout.OnTabSelectedListener() {
                                                       @Override
                                                       public void onTabSelected(TabLayout.Tab tab) {
                                                           viewPagerDatosComplementarios.setCurrentItem(tab.getPosition());
                                                       }

                                                       @Override
                                                       public void onTabUnselected(TabLayout.Tab tab) {

                                                       }

                                                       @Override
                                                       public void onTabReselected(TabLayout.Tab tab) {

                                                       }

                                                   });

        tabLayout.setupWithViewPager(viewPagerDatosComplementarios);

        /*for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(this, i));
        }*/
    }

    /**
     * Metodo para cargar los detalles del equipo en la toolbar
     */
    private void cargaDetallesEquipo() {


        if (this.empatados != null) {
            this.recordEquipo = this.ganados + " - " + this.perdidos + " - " + this.empatados;
        } else {
            this.recordEquipo = this.ganados + " - " + this.perdidos;
        }

        tvEquipoEnToolbar.setText(nombreEquipo);
        recordEquipoEnToolbar.setText(recordEquipo);
/*
        int resourceId = getResources().getIdentifier("logo_" + nombreEquipo.toLowerCase() + "_fondo_color_sin_texto", "drawable", "com.proyectofootball.titanes.lfa");
        imgLogoEquipoToolbar.setImageResource(resourceId);*/
    }
}
