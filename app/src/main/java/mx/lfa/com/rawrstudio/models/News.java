package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class News {

    private Integer id;
    private String date;
    private String link;
    private Title title;
    private Content content;
    private Integer author;
    private Integer featuredMedia;
    private Better_Featured_Image better_featured_image;
    private Links links;

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
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets link.
     *
     * @param link the link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     * Gets featured media.
     *
     * @return the featured media
     */
    public Integer getFeaturedMedia() {
        return featuredMedia;
    }

    /**
     * Sets featured media.
     *
     * @param featuredMedia the featured media
     */
    public void setFeaturedMedia(Integer featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    /**
     * Gets better featured image.
     *
     * @return the better featured image
     */
    public Better_Featured_Image getBetter_featured_image() {
        return better_featured_image;
    }

    /**
     * Sets better featured image.
     *
     * @param better_featured_image the better featured image
     */
    public void setBetter_featured_image(Better_Featured_Image better_featured_image) {
        this.better_featured_image = better_featured_image;
    }

    /**
     * Gets links.
     *
     * @return the links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * Sets links.
     *
     * @param links the links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", link='" + link + '\'' +
                ", title=" + title +
                ", content=" + content +
                ", author=" + author +
                ", featuredMedia=" + featuredMedia +
                ", better_featured_image=" + better_featured_image +
                ", links=" + links +
                '}';
    }
}
