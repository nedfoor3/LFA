package mx.lfa.com.rawrstudio.models;

/**
 * Created by Ricardo Rodriguez on 4/11/2017.
 */
public class Title {

    private String rendered;

    /**
     * Gets rendered.
     *
     * @return the rendered
     */
    public String getRendered() {
        return rendered;
    }

    /**
     * Sets rendered.
     *
     * @param rendered the rendered
     */
    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    @Override
    public String toString() {
        return "Title{" +
                "rendered='" + rendered + '\'' +
                '}';
    }
}
