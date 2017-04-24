package mx.lfa.com.rawrstudio.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Tonatiuh on 19/04/2017.
 */
public class PreferenciasFragment extends PreferenceFragment {

    public static final String KEY_LIST_PREFERENCE = "preferencias_principal";

    private ListPreference mListPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        mListPreference = (ListPreference) getPreferenceScreen().findPreference(KEY_LIST_PREFERENCE);

    }

    @Override
    public void onResume() {
        super.onResume();

        mListPreference.setSummary("Current value is " + mListPreference.getEntry().toString());
    }

    public void mostrarPreferencias(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String s = "idiomas: "+ pref.getBoolean("idiomas",true);
//                +", máximo a listar: " + pref.getString("maximo","?");
        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
