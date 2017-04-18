package mx.lfa.com.rawrstudio.views;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interfaces.Menu.ActionbarView;
import mx.lfa.com.rawrstudio.presenters.MenuPresenterImpl;

public class StandingsActivity extends AppCompatActivity implements ActionbarView {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_dias)
    TextView tvDias;
    @BindView(R.id.tv_horas)
    TextView tvHoras;
    @BindView(R.id.tv_minutos)
    TextView tvMinutos;
    @BindView(R.id.tv_segundos)
    TextView tvSegundos;
    @BindView(R.id.layout_timer)
    LinearLayout layoutTimer;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.tv_grupo_suerox)
    TextView tvGrupoSuerox;
    @BindView(R.id.tabla_grupo_suerox)
    TableLayout tablaGrupoSuerox;
    @BindView(R.id.tv_grupo_under_armour)
    TextView tvGrupoUnderArmour;
    @BindView(R.id.tabla_grupo_under_armour)
    TableLayout tablaGrupoUnderArmour;
    @BindView(R.id.main_toolbar)
    LinearLayout mainToolbar;
    @BindView(R.id.lateral_menu)
    NavigationView lateralMenu;
    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayoutMain;

    private MenuPresenterImpl mMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        ButterKnife.bind(this);

        // Toolbar and Menu
        ActionbarView actionbarView = this;
        actionbarView.setToolbarValues();

        // Menu Presenter Logic
        mMenuPresenter = new MenuPresenterImpl(this);
        mMenuPresenter.onClickOptionItemMenu(lateralMenu, drawerLayoutMain);
    }

    /**
     * Op Options Item Selected
     *
     * @param item
     * @return
     */
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

    /**
     * Sets toolbar values.
     */
    @Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
