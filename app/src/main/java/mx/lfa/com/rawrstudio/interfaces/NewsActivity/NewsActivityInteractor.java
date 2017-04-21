package mx.lfa.com.rawrstudio.interfaces.NewsActivity;

import java.util.List;

import mx.lfa.com.rawrstudio.models.MediaData;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public interface NewsActivityInteractor {
    /**
     * Gets custom date.
     *
     * @param originalDate the original date
     * @return the custom date
     */
    String getCustomDate(String originalDate);

    /**
     * Gets urls media.
     */
    List<MediaData> getUrlsMedia(int idMedia);
}
