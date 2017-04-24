package mx.lfa.com.rawrstudio.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.utils.LocaleHelper;

public class SettingsActivity extends PreferenceActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String LANGUAGE = "idioma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        Preference pref = new ListPreference(this);
        ListPreference listPref = (ListPreference) pref;


        pref.setSummary(LocaleHelper.getLanguage(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);

        switch (key) {
            case LANGUAGE:

                ListPreference listPref = (ListPreference) preference;


                preference.setSummary(listPref.getEntry());

                Context context = LocaleHelper.setLocale(this, listPref.getValue());


                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

            default:
                return;
        }

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}
