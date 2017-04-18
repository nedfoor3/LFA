package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class MediumLarge {
    private String file;
    private Integer width;
    private Integer height;
    private String mimeType;
    private String sourceUrl;

    /**
     * Gets file.
     *
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets file.
     *
     * @param file the file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets mime type.
     *
     * @return the mime type
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets mime type.
     *
     * @param mimeType the mime type
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Gets source url.
     *
     * @return the source url
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * Sets source url.
     *
     * @param sourceUrl the source url
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "MediumLarge{" +
                "file='" + file + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", mimeType='" + mimeType + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }
}
