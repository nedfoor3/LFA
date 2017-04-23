package mx.lfa.com.rawrstudio.views;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mx.lfa.com.rawrstudio.R;

public class Equipos extends AppCompatActivity {
    ImageButton btnCondors, btnDinos, btnFundidores, btnEagles, btnMayas, btnRaptors;
    private DatabaseReference mDadabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_equipos);
        
        iniGUIEquipos();
        iniListenersEquipos();
    }
    
    public void iniGUIEquipos(){
        btnCondors = (ImageButton)findViewById(R.id.header_condors);
        btnDinos = (ImageButton)findViewById(R.id.header_dinos);
        btnEagles = (ImageButton)findViewById(R.id.header_eagles);
        btnFundidores = (ImageButton)findViewById(R.id.header_fundidores);
        btnMayas = (ImageButton)findViewById(R.id.header_mayas);
        btnRaptors = (ImageButton)findViewById(R.id.header_raptors);
    }

    public void iniListenersEquipos(){
            mDadabaseReference = FirebaseDatabase.getInstance().getReference().child("2017/equipo");


        btnCondors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCondors = new Intent(Equipos.this, DetalleEquipos.class);
                intentCondors.putExtra("nombreEquipo", "Condors");
                intentCondors.putExtra("ganados", "2");
                intentCondors.putExtra("perdidos", "5");
                intentCondors.putExtra("empatados", "0");
                startActivity(intentCondors);
            }
        });
    }



}
