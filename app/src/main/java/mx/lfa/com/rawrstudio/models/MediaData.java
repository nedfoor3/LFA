package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/20/2017.
 */
public class MediaData {
    private Integer id;
    private Guid guid;
    private String media_type;
    private String mime_type;

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
     * Gets guid.
     *
     * @return the guid
     */
    public Guid getGuid() {
        return guid;
    }

    /**
     * Sets guid.
     *
     * @param guid the guid
     */
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    /**
     * Gets media type.
     *
     * @return the media type
     */
    public String getMedia_type() {
        return media_type;
    }

    /**
     * Sets media type.
     *
     * @param media_type the media type
     */
    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    /**
     * Gets mime type.
     *
     * @return the mime type
     */
    public String getMime_type() {
        return mime_type;
    }

    /**
     * Sets mime type.
     *
     * @param mime_type the mime type
     */
    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    @Override
    public String toString() {
        return "MediaData{" +
                "id=" + id +
                ", guid=" + guid +
                ", media_type='" + media_type + '\'' +
                ", mime_type='" + mime_type + '\'' +
                '}';
    }
}
