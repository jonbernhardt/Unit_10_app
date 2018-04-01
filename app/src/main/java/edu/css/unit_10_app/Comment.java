package edu.css.unit_10_app;

/**
 * Created by Jon Bernhardt on 3/27/2018.
 */

public class Comment {
    private long id;
    private String comment;
    private String rating;

    /**
     * Returns rating
     * @return
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets rating
     * @param rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }


    /**
     * Returns comment id
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Sets comment id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the comment string
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment string
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the comment as a string
     * @return
     */
    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return "Rating: " + rating + " " + comment;
    }
}
