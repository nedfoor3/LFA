package mx.lfa.com.rawrstudio.interactors;

import android.content.Context;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.lfa.com.rawrstudio.dao.RetrofitNewsDao;
import mx.lfa.com.rawrstudio.interfaces.NewsActivity.NewsActivityInteractor;
import mx.lfa.com.rawrstudio.models.MediaData;
import mx.lfa.com.rawrstudio.utils.Strings;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */

public class NewsActivityInteractorImpl implements NewsActivityInteractor {

    private static final int HTTP_SUCCESS_RESPONCE = 200;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");

    private Context context;

    public NewsActivityInteractorImpl(Context context) {
        this.context = context;
    }

    /**
     * Gets custom date.
     *
     * @return the custom date
     */
    @Override
    public String getCustomDate(String originalDate) {


        Date date = null;
        String newstring = "";
        try {
            date = sdf.parse(originalDate);
            newstring = new SimpleDateFormat("dd-mm-yyyy").format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Toast.makeText(context, "fecha:" + date.toString(), Toast.LENGTH_SHORT).show();
        //Log.v("hola", date.toString());
        return newstring;

    }

    /**
     * Gets urls media.
     */
    @Override
    public List<MediaData> getUrlsMedia(int idMedia) {

        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl(Strings.BASE_NEWS_API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitNewsDao retrofitNewsDaoService = retrofit.create(RetrofitNewsDao.class);

        Call<List<MediaData>> call = retrofitNewsDaoService.getMediaData(idMedia);

        List<MediaData> mMediaData = new ArrayList<>();

        try {

            if (HTTP_SUCCESS_RESPONCE == call.execute().code()) {

                Call<List<MediaData>> mCall = call.clone();
                mMediaData = mCall.execute().body();
            } else {
                mMediaData = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mMediaData;

    }
}
