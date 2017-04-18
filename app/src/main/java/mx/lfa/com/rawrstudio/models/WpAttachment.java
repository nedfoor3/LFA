package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class WpAttachment {
    private String href;

    /**
     * Gets href.
     *
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets href.
     *
     * @param href the href
     */
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "WpAttachment{" +
                "href='" + href + '\'' +
                '}';
    }
}
