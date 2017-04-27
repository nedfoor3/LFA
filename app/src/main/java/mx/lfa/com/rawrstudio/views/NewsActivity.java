package mx.lfa.com.rawrstudio.views;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.interfaces.Menu.ActionbarView;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityPresenter;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityView;
import mx.lfa.com.rawrstudio.models.MediaData;
import mx.lfa.com.rawrstudio.presenters.NewsActivityPresenterImpl;
import mx.lfa.com.rawrstudio.utils.Strings;

/**
 * The type News activity.
 */
public class NewsActivity extends AppCompatActivity implements ActionbarView, NewsActivityView {


    /**
     * The Toolbar.
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /**
     * The Btn try again.
     */
    @BindView(R.id.btn_try_again)
    Button btnTryAgain;
    /**
     * The Layout cant load.
     */
    @BindView(R.id.layout_cant_load)
    LinearLayout layoutCantLoad;
    /**
     * The Progress bar.
     */
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    /**
     * The Pager gallery.
     */
    @BindView(R.id.pager_gallery)
    ViewPager pagerGallery;
    /**
     * The Tv title.
     */
    @BindView(R.id.tv_title)
    TextView tvTitle;
    /**
     * The Tv date.
     */
    @BindView(R.id.tv_date)
    TextView tvDate;
    /**
     * The Tv text.
     */
    @BindView(R.id.tv_text)
    WebView tvText;
    /**
     * The Layout full article.
     */
    @BindView(R.id.layout_full_article)
    LinearLayout layoutFullArticle;
    /**
     * The Main toolbar.
     */
    @BindView(R.id.main_toolbar)
    LinearLayout mainToolbar;
    /**
     * The Drawer layout main.
     */
    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayoutMain;
    /**
     * The Indicator.
     */
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private ActionbarView actionbarView;
    private NewsActivityPresenter newsActivityPresenter;
    private String title;
    private String text;
    private String date;
    private int idMedia;
    private String mUrlFeature;

    private List<MediaData> listMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        title = extras.getString(Strings.INTENT_NEWS_TITLE);
        text = extras.getString(Strings.INTENT_NEWS_TEXT);
        date = extras.getString(Strings.INTENT_NEWS_DATE);
        idMedia = extras.getInt(Strings.INTENT_NEWS_ID_MEDIA);
        mUrlFeature = extras.getString(Strings.INTENT_NEWS_URL_FEAUTRE);

        actionbarView = this;
        actionbarView.setToolbarValues();

        newsActivityPresenter = new NewsActivityPresenterImpl(this, idMedia, mUrlFeature, date);
        newsActivityPresenter.loadArticle();


    }

    /**
     * Sets toolbar values.
     */
    @Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //drawerLayoutMain.openDrawer(GravityCompat.START);
                finish();
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
     * Show article.
     */
    @Override
    public void showArticle() {
        layoutFullArticle.setVisibility(View.VISIBLE);

    }

    /**
     * Hide article.
     */
    @Override
    public void hideArticle() {
        layoutFullArticle.setVisibility(View.GONE);
    }

    /**
     * Show cant load error.
     */
    @Override
    public void showCantLoadError() {
        layoutCantLoad.setVisibility(View.VISIBLE);
    }

    /**
     * Hide cant load error.
     */
    @Override
    public void hideCantLoadError() {
        layoutCantLoad.setVisibility(View.GONE);
    }

    /**
     * Sets title.
     */
    @Override
    public void setTitle() {
        tvTitle.setText(title);
    }

    /**
     * Sets text.
     */
    @Override
    public void setText() {
        tvText.getSettings().setJavaScriptEnabled(true);
        tvText.getSettings().setJavaScriptEnabled(true);
        tvText.getSettings().setLoadWithOverviewMode(true);
        tvText.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        tvText.setScrollbarFadingEnabled(false);

        this.text = text.replaceAll("<img.+?>", "");

        tvText.loadDataWithBaseURL("", this.text, "text/html", "UTF-8", "");
    }

    /**
     * Sets date.
     */
    @Override
    public void setDate(String customDate) {

    }

    /**
     * Gets list media.
     *
     * @return the list media
     */
    public List<MediaData> getListMedia() {
        return listMedia;
    }

    /**
     * Sets list media.
     *
     * @param listMedia the list media
     */
    public void setListMedia(List<MediaData> listMedia) {
        this.listMedia = listMedia;
    }

    /**
     * Gets pager gallery.
     *
     * @return the pager gallery
     */
    public ViewPager getPagerGallery() {
        return pagerGallery;
    }

    /**
     * Gets indicator.
     *
     * @return the indicator
     */
    public CircleIndicator getIndicator() {
        return indicator;
    }

    /**
     * Sets indicator.
     *
     * @param indicator the indicator
     */
    public void setIndicator(CircleIndicator indicator) {
        this.indicator = indicator;
    }
}
