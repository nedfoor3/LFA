package mx.lfa.com.rawrstudio.views;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.R;

public class AcercaDe extends AppCompatActivity {
    public TextView tvContacto, tvDesarrollo;
    public ImageView imgLogoHead;
    public RelativeLayout paraLetrasRawr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_acerca_de);
        //tvContacto = (TextView)findViewById(R.id.contacto_rawr);
        tvDesarrollo = (TextView)findViewById(R.id.tv_develop);
        imgLogoHead = (ImageView)findViewById(R.id.iv_logo_head);
        paraLetrasRawr = (RelativeLayout)findViewById(R.id.rawr_letras);
        //Typeface cabinSketch = Typeface.createFromAsset(getAssets(), "fonts/CabinSketch-Regular.ttf");
        //Typeface fingerPaint = Typeface.createFromAsset(getAssets(), "fonts/IndieFlower.ttf");
        //tvDesarrollo.setTypeface(cabinSketch);
        //tvContacto.setTypeface(fingerPaint);

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/

        imgLogoHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarWeb(view);
            }
        });

        paraLetrasRawr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarCorreo(view);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mandarCorreo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        //intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
        //intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {getResources().getString(R.string.correo_soporte_rawr)});
        startActivity(intent);
    }

    public void lanzarWeb(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lfa.mx"));
        startActivity(browserIntent);
    }

}