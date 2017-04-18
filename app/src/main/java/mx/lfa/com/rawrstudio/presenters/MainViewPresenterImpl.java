package mx.lfa.com.rawrstudio.presenters;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.lfa.com.rawrstudio.MainActivity;
import mx.lfa.com.rawrstudio.asyncs.GetNewsSwipContainerAsync;
import mx.lfa.com.rawrstudio.asyncs.GetOldNewsAsync;
import mx.lfa.com.rawrstudio.asyncs.GetRecentNewsListAsync;
import mx.lfa.com.rawrstudio.interfaces.MainActivity.MainActivityPresenter;
import mx.lfa.com.rawrstudio.utils.Footer;
import mx.lfa.com.rawrstudio.utils.Formats;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class MainViewPresenterImpl extends RecyclerView.OnScrollListener implements MainActivityPresenter {

    private MainActivity view;
    private RecyclerView mRecyclerView;

    private int totalItemCount;

    private boolean loading;
    private int lastVisibleItem;
    private int counterPage = 2;


    /**
     * Instantiates a new Main view presenter.
     *
     * @param view         the view
     * @param recyclerView the recycler view
     */
    public MainViewPresenterImpl(final MainActivity view, final RecyclerView recyclerView) {
        this.view = view;
        this.mRecyclerView = recyclerView;

        // To load old news
        this.mRecyclerView.addOnScrollListener(this);

    }


    /**
     * Load news.
     */
    @Override
    public void loadNews() {

        if (view != null) {
            GetRecentNewsListAsync getRecentNewsListAsync = new GetRecentNewsListAsync(view, mRecyclerView);
            getRecentNewsListAsync.execute();
        }


    }

    /**
     * Load news swip container.
     */
    @Override
    public void loadNewsSwipContainer() {
        if (view != null) {
            GetNewsSwipContainerAsync getNewsSwipContainerAsync = new GetNewsSwipContainerAsync(view, mRecyclerView);
            getNewsSwipContainerAsync.execute();
            counterPage = 2;
        }

    }

    /**
     * Load old news.
     *
     * @param counterPage
     */
    @Override
    public void loadOldNews(int counterPage) {
        if (view != null) {
            GetOldNewsAsync getOldNewsAsync = new GetOldNewsAsync(view, mRecyclerView, counterPage);
            getOldNewsAsync.execute();
            //agregar algo para controlar el counter page
        }

    }

    /**
     * Sets countdown.
     */
    @Override
    public void setCountdown() {
        if (view != null) {
            boolean flagCoutdown = false;

            //ESTE METODO SE DEBE OPTIMIZAR, PARA OBTENER EL FUTURE DATE DE OTRO LADO (SE RECOMIENDA PASAR
            // AL INTERACTOR)


            final Handler handler = new Handler();

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    SimpleDateFormat format = Formats.getDateFormat();
                    handler.postDelayed(this, 1000);
                    try {
                        Date futureDate = format.parse("2017-04-30 14:00");
                        Date currentDate = new Date();

                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        view.getTvDias().setText("" + String.format("%02d", days));
                        view.getTvHoras().setText("" + String.format("%02d", hours));
                        view.getTvMinutos().setText(""
                                + String.format("%02d", minutes));
                        view.getTvSegundos().setText(""
                                + String.format("%02d", seconds));


                        if (!currentDate.after(futureDate)) {
                            view.showTimer();
                        } else {
                            view.hideTimer();
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            };

            handler.postDelayed(runnable, 1 * 1000);


        }

    }

    @Override
    public void onScrolled(final RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        totalItemCount = layoutManager.getItemCount();
        lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();

        if (loading) {

            loading = false;
        }

        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (!loading && !(hasFooter()) && linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 2) {
            view.getLisNews().add(new Footer());
            loading = true;
            Handler handler = new Handler();

            final Runnable r = new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.getAdapter().notifyItemInserted(view.getLisNews().size() - 1);
                }
            };

            handler.post(r);
            loadOldNews(counterPage);
            counterPage++;

        }

    }

    private boolean hasFooter() {
        return view.getLisNews().get(view.getLisNews().size() - 1) instanceof Footer;
    }

}
