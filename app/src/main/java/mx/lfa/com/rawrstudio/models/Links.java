package mx.lfa.com.rawrstudio.models;

import java.util.List;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class Links {

    private List<WpAttachment> wpAttachment;

    /**
     * Gets wp attachment.
     *
     * @return the wp attachment
     */
    public List<WpAttachment> getWpAttachment() {
        return wpAttachment;
    }

    /**
     * Sets wp attachment.
     *
     * @param wpAttachment the wp attachment
     */
    public void setWpAttachment(List<WpAttachment> wpAttachment) {
        this.wpAttachment = wpAttachment;
    }

    @Override
    public String toString() {
        return "Links{" +
                "wpAttachment=" + wpAttachment +
                '}';
    }
}
