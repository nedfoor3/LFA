package mx.lfa.com.rawrstudio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.adapters.NewsAdapter;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityPresenter;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityView;
import mx.lfa.com.rawrstudio.interfaces.Menu.ActionbarView;
import mx.lfa.com.rawrstudio.interfaces.Menu.MenuPresenter;
import mx.lfa.com.rawrstudio.models.News;
import mx.lfa.com.rawrstudio.presenters.MainViewPresenterImpl;
import mx.lfa.com.rawrstudio.presenters.MenuPresenterImpl;
import mx.lfa.com.rawrstudio.utils.LocaleHelper;
import mx.lfa.com.rawrstudio.views.TazonPlayByPlay;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements ActionbarView, MainActivityView, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerview_news)
    RecyclerView recyclerviewNews;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.main_toolbar)
    LinearLayout mainToolbar;
    @BindView(R.id.lateral_menu)
    NavigationView lateralMenu;
    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayoutMain;
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
    @BindView(R.id.btn_try_again)
    Button btnTryAgain;
    @BindView(R.id.layout_cant_load)
    LinearLayout layoutCantLoad;
    @BindView(R.id.mascara)
    Button mascara;

    private MenuPresenter mMenuPresenter;
    private MainActivityPresenter mMainActivityPresenter;
    private NewsAdapter newsAdapter;
    private List<News> lisNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Toolbar and Menu
        ActionbarView actionbarView = this;
        actionbarView.setToolbarValues();

        // Recyclerview
        recyclerviewNews.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerviewNews.setLayoutManager(linearLayoutManager);

        // Menu Presenter Logic
        mMenuPresenter = new MenuPresenterImpl(this);
        mMenuPresenter.onClickOptionItemMenu(lateralMenu, drawerLayoutMain);

        // Main Activity Presenter Logic
        mMainActivityPresenter = new MainViewPresenterImpl(this, recyclerviewNews);
        mMainActivityPresenter.setCountdown();
        mMainActivityPresenter.loadNews();

        // Swip
        swipeContainer.setOnRefreshListener(this);

        mascara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TazonPlayByPlay.class));
            }
        });

    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    /**
     * Sets toolbar values.
     */
    @Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
     * Show progress.
     */
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * Hide progress.
     */
    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    /**
     * Hide progress swip container.
     */
    @Override
    public void hideProgressSwipContainer() {
        swipeContainer.setRefreshing(false);
    }

    /**
     * Show timer.
     */
    @Override
    public void showTimer() {
        layoutTimer.setVisibility(View.VISIBLE);
    }

    /**
     * Hide timer.
     */
    @Override
    public void hideTimer() {
        layoutTimer.setVisibility(View.GONE);
    }

    /**
     * Show timer.
     */
    //@Override
    public void showBtnTazon() {
        mascara.setVisibility(View.VISIBLE);
        tvSegundos.setText("00");
        tvMinutos.setText("00");
        tvHoras.setText("00");
        tvDias.setText("00");
    }

    /**
     * Hide timer.
     */
    //@Override
    public void hideBtnTimer() {
        mascara.setVisibility(View.GONE);
    }

    /**
     * Show cant load error.
     */
    @Override
    public void showCantLoadError() {
        layoutCantLoad.setVisibility(View.VISIBLE);
        recyclerviewNews.setVisibility(View.GONE);
    }

    /**
     * Hide cant load error.
     */
    @Override
    public void hideCantLoadError() {
        layoutCantLoad.setVisibility(View.GONE);
        recyclerviewNews.setVisibility(View.VISIBLE);
    }


    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        mMainActivityPresenter.loadNewsSwipContainer();
    }

    public NewsAdapter getNewsAdapter() {
        return newsAdapter;
    }

    public void setNewsAdapter(NewsAdapter newsAdapter) {
        this.newsAdapter = newsAdapter;
    }

    public List<News> getLisNews() {
        return lisNews;
    }

    public void setLisNews(List<News> lisNews) {
        this.lisNews = lisNews;
    }

    public TextView getTvDias() {
        return tvDias;
    }

    public void setTvDias(TextView tvDias) {
        this.tvDias = tvDias;
    }

    public TextView getTvHoras() {
        return tvHoras;
    }

    public void setTvHoras(TextView tvHoras) {
        this.tvHoras = tvHoras;
    }

    public TextView getTvMinutos() {
        return tvMinutos;
    }

    public void setTvMinutos(TextView tvMinutos) {
        this.tvMinutos = tvMinutos;
    }

    public TextView getTvSegundos() {
        return tvSegundos;
    }

    public void setTvSegundos(TextView tvSegundos) {
        this.tvSegundos = tvSegundos;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}
