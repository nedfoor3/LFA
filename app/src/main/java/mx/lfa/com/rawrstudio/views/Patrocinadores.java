package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.adapters.ViewPagerAdapter;

public class Patrocinadores extends AppCompatActivity {
    ViewPager viewPagerSponsor;
    PagerAdapter pagerAdapterSponsor;
    int[] imagenes;
    private static int currentPage = 0;
    private static int numPages = 0;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_patrocinadores);
        ButterKnife.bind(this);

        progressBar.setVisibility(View.VISIBLE);
        imagenes = new int[]{R.drawable.rawrlogo, R.drawable.ua, R.drawable.sinergia, R.drawable.polaris, R.drawable.cramer,
                R.drawable.suerox, R.drawable.livyc, R.drawable.amfa, R.drawable.uvm, R.drawable.sportway, R.drawable.musol, R.drawable.dicass,
                R.drawable.runxpert, R.drawable.sportsclinic};
        viewPagerSponsor = (ViewPager) findViewById(R.id.pager_patrocinadores);
        pagerAdapterSponsor = new ViewPagerAdapter(Patrocinadores.this, imagenes);
        viewPagerSponsor.setAdapter(pagerAdapterSponsor);

        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicador_patrocinadores);
        circleIndicator.setViewPager(viewPagerSponsor);
        viewPagerSponsor.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = imagenes.length;
                    if (currentPage == 0) {
                        viewPagerSponsor.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        viewPagerSponsor.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == numPages) {
                    currentPage = 0;
                }
                viewPagerSponsor.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 1000);

        progressBar.setVisibility(View.INVISIBLE);
    }


}
