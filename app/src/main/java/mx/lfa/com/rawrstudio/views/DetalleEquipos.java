package mx.lfa.com.rawrstudio.views;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.adapters.ViewPagerAdapter;
import mx.lfa.com.rawrstudio.fragments.CalendarFragment;
import mx.lfa.com.rawrstudio.fragments.RosterFragment;

public class DetalleEquipos extends AppCompatActivity {

    //private FragmentPagerAdapter adapter;
    private ViewPager viewPagerTeams;
    private ViewPagerAdapter viewPagerAdapter;
    private Bundle bundle;
    private Toolbar toolbarDetailTeams;
    private TabLayout tabLayoutDetalle;

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
        //ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));

        instanciarElementos();

        cargaDetallesEquipo();
    }

    private void instanciarElementos() {
        setSupportActionBar(toolbarDetailTeams);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle extras = getIntent().getExtras();

        this.nombreEquipo = extras.getString(NOMBRE_EQUIPO);
        this.ganados = extras.getString(PARTIDOS_GANADOS);
        this.perdidos = extras.getString(PARTIDOS_PERDIDOS);
        this.empatados = extras.getString(PARTIDOS_EMPATADOS);

        viewPagerTeams = (ViewPager) findViewById(R.id.viewPager_datos_complementarios);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
       // viewPagerAdapter.addFragments(new CalendarFragment(), getResources().getString(R.string.empty));
       // viewPagerAdapter.addFragments(new RosterFragment(), getResources().getString(R.string.empty));
        viewPagerTeams.setAdapter(viewPagerAdapter);
        tabLayoutDetalle.setupWithViewPager(viewPagerTeams);

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

//        tvEquipoEnToolbar.setText(nombreEquipo);
//        recordEquipoEnToolbar.setText(recordEquipo);

        //        int resourceId = getResources().getIdentifier("logo_" + nombreEquipo.toLowerCase() + "_fondo_color_sin_texto", "drawable", "com.proyectofootball.titanes.lfa");
        //imgLogoEquipoToolbar.setImageResource(resourceId);
    }
}
