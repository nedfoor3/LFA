package mx.lfa.com.rawrstudio.presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interfaces.Menu.MenuPresenter;
import mx.lfa.com.rawrstudio.views.AcercaDe;
import mx.lfa.com.rawrstudio.views.Equipos;
import mx.lfa.com.rawrstudio.views.Patrocinadores;
import mx.lfa.com.rawrstudio.views.SettingsActivity;
import mx.lfa.com.rawrstudio.views.StandingsActivity;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class MenuPresenterImpl implements MenuPresenter {

    private Activity view;

    private static final String MAIN_ACTIVITY_CLASS = "MainActivity";
    private static final String TEAMS_CLASS = "Equipos";
    private static final String STANDINGS_ACTIVITY_CLASS = "StandingsActivity";
    private static final String SPONSORS_ACTIVITY_CLASS = "Patrocinadores";
    private static final String ABOUT_CLASS = "AcercaDe";
    private static final String SETTINGS_ACTIVITY_CLASS = "SettingsActivity";

    /**
     * Instantiates a new Menu presenter.
     *
     * @param view the view
     */
    public MenuPresenterImpl(Activity view) {
        this.view = view;
    }

    /**
     * On click option item menu.
     *
     * @param navigationView the navigation view
     * @param drawerLayout   the drawer layout
     */
    @Override
    public void onClickOptionItemMenu(NavigationView navigationView, DrawerLayout drawerLayout) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            /**
             * Called when an item in the navigation menu is selected.
             *
             * @param item The selected item
             * @return true to display the item as the selected item
             */
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean activityTransaction = false;

                //Switch to configure each lateral menu element

                Intent intent = null;

                switch (item.getItemId()) {
                    case R.id.menu_news:
                        intent = new Intent(view, MainActivity.class);
                        view.startActivity(intent);
                        activityTransaction = true;
                        break;
                    case R.id.menu_teams:

                        intent = new Intent(view, Equipos.class);
                        view.startActivity(intent);
                        activityTransaction = true;

                        break;
                    case R.id.menu_standings:

                        intent = new Intent(view, StandingsActivity.class);

                        view.startActivity(intent);
                        activityTransaction = true;

                        break;
                    case R.id.menu_sponsors:
                        intent = new Intent(view, Patrocinadores.class);

                        view.startActivity(intent);
                        activityTransaction = true;

                        break;
                    case R.id.menu_about:

                        intent = new Intent(view, AcercaDe.class);

                        view.startActivity(intent);
                        activityTransaction = true;

                        break;
                    case R.id.menu_config:

                        intent = new Intent(view, SettingsActivity.class);
                        view.startActivity(intent);

                        activityTransaction = true;

                        break;
                }
                return activityTransaction;
            }
        });
    }

}
