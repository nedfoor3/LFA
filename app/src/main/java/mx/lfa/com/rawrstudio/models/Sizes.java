package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class Sizes {
    private Thumbnail thumbnail;
    private Medium medium;
    private MediumLarge mediumLarge;
    private Large large;
    private TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar;


    /**
     * Gets thumbnail.
     *
     * @return the thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets thumbnail.
     *
     * @param thumbnail the thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Gets medium.
     *
     * @return the medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     * Sets medium.
     *
     * @param medium the medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     * Gets medium large.
     *
     * @return the medium large
     */
    public MediumLarge getMediumLarge() {
        return mediumLarge;
    }

    /**
     * Sets medium large.
     *
     * @param mediumLarge the medium large
     */
    public void setMediumLarge(MediumLarge mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    /**
     * Gets large.
     *
     * @return the large
     */
    public Large getLarge() {
        return large;
    }

    /**
     * Sets large.
     *
     * @param large the large
     */
    public void setLarge(Large large) {
        this.large = large;
    }

    /**
     * Gets twentyseventeen thumbnail avatar.
     *
     * @return the twentyseventeen thumbnail avatar
     */
    public TwentyseventeenThumbnailAvatar getTwentyseventeenThumbnailAvatar() {
        return twentyseventeenThumbnailAvatar;
    }

    /**
     * Sets twentyseventeen thumbnail avatar.
     *
     * @param twentyseventeenThumbnailAvatar the twentyseventeen thumbnail avatar
     */
    public void setTwentyseventeenThumbnailAvatar(TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar) {
        this.twentyseventeenThumbnailAvatar = twentyseventeenThumbnailAvatar;
    }

    @Override
    public String toString() {
        return "Sizes{" +
                "thumbnail=" + thumbnail +
                ", medium=" + medium +
                ", mediumLarge=" + mediumLarge +
                ", large=" + large +
                ", twentyseventeenThumbnailAvatar=" + twentyseventeenThumbnailAvatar +
                '}';
    }
}
