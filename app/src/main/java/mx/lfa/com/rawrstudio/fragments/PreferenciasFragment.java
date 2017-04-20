package mx.lfa.com.rawrstudio.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Tonatiuh on 19/04/2017.
 */
public class PreferenciasFragment extends PreferenceFragment {
    //SharedPreferences prefLFA =

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }

    public void mostrarPreferencias(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String s = "idiomas: "+ pref.getBoolean("idiomas",true);
//                +", máximo a listar: " + pref.getString("maximo","?");
        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
