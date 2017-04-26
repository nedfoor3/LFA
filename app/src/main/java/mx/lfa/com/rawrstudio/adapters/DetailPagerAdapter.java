package mx.lfa.com.rawrstudio.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mx.lfa.com.rawrstudio.fragments.CalendarFragmet;
import mx.lfa.com.rawrstudio.fragments.RostersFragment;

/**
 * Created by Ricardo Rodriguez on 4/25/2017.
 */

public class DetailPagerAdapter extends FragmentPagerAdapter {
    String tabTitles[] = new String[]{"Calendario", "Roster"};
    private static int NUM_ITEMS = 2;
    String nombreEquipo;
    Bundle args = new Bundle();

    public DetailPagerAdapter(FragmentManager fm, String nombreE) {
        super(fm);
        this.nombreEquipo = nombreE;
        args.putString("nombreEquipo", nombreEquipo);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CalendarFragmet fragmet = new CalendarFragmet();
                fragmet.setArguments(args);
                return fragmet;
            case 1:

                RostersFragment fragment = new RostersFragment();
                fragment.setArguments(args);
                return fragment;
            default:
                return null;
        }

    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
