package mx.lfa.com.rawrstudio.interfaces.Menu;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public interface MenuPresenter {

    /**
     * On click option item menu.
     *
     * @param navigationView the navigation view
     * @param drawerLayout   the drawer layout
     */
    void onClickOptionItemMenu(NavigationView navigationView, DrawerLayout drawerLayout);
}
