package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class Better_Featured_Image {
    private Integer id;
    private String mediaType;
    private MediaDetails mediaDetails;
    private String source_url;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets media type.
     *
     * @return the media type
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets media type.
     *
     * @param mediaType the media type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Gets media details.
     *
     * @return the media details
     */
    public MediaDetails getMediaDetails() {
        return mediaDetails;
    }

    /**
     * Sets media details.
     *
     * @param mediaDetails the media details
     */
    public void setMediaDetails(MediaDetails mediaDetails) {
        this.mediaDetails = mediaDetails;
    }

    /**
     * Gets source url.
     *
     * @return the source url
     */
    public String getSource_url() {
        return source_url;
    }

    /**
     * Sets source url.
     *
     * @param source_url the source url
     */
    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    @Override
    public String toString() {
        return "Better_Featured_Image{" +
                "id=" + id +
                ", mediaType='" + mediaType + '\'' +
                ", mediaDetails=" + mediaDetails +
                ", source_url='" + source_url + '\'' +
                '}';
    }
}
