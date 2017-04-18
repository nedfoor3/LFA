package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class MediaDetails {
    private Integer width;
    private Integer height;
    private String file;
    private Sizes sizes;

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
     * Gets sizes.
     *
     * @return the sizes
     */
    public Sizes getSizes() {
        return sizes;
    }

    /**
     * Sets sizes.
     *
     * @param sizes the sizes
     */
    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "MediaDetails{" +
                "width=" + width +
                ", height=" + height +
                ", file='" + file + '\'' +
                ", sizes=" + sizes +
                '}';
    }
}
