package mx.lfa.com.rawrstudio.views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.adapters.DetailPagerAdapter;

public class DetalleEquipos extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.record_equipo_en_toolbar)
    TextView recordEquipoEnToolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_datos_complementarios)
    ViewPager viewPagerDatosComplementarios;
    @BindView(R.id.main_toolbar)
    LinearLayout mainToolbar;
    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayoutMain;
    @BindView(R.id.image_toolbar)
    ImageView imageToolbar;
    private FragmentPagerAdapter adapter;

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

        instanciarElementos();

        cargaDetallesEquipo();

        /*MenuGenerico mMenu = new MenuGenerico();
        mMenu.crearMenu(this);*/


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //drawerLayoutMain.openDrawer(GravityCompat.START);
                finish();
                return true;
            //...
        }
        return super.onOptionsItemSelected(item);
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

        adapter = new DetailPagerAdapter(getSupportFragmentManager(), this.nombreEquipo);
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

        //tvEquipoEnToolbar.setText(nombreEquipo);
        recordEquipoEnToolbar.setText(recordEquipo);

        int resourceId = getResources().getIdentifier("escudo_" + nombreEquipo.toLowerCase(), "drawable", "mx.lfa.com.rawrstudio");
        imageToolbar.setBackgroundResource(resourceId);
        /*logoEquipoEnToolbar.setImageResource(resourceId);*/
    }


}