/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author kl.osorio10
 */
@Entity
public class EventoEntity extends BaseEntity implements Serializable  {

    private String place;
    private ArrayList<String> comments;
    private String category;
    private double score;
    private String image;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String description;

    //Toda definir bien las relaciones con Itenerario, Multimedia, Timeline, PlanEvento
   // @ManyToMany
   // private List<AuthorEntity> authors = new ArrayList<>();

   // @ManyToOne
   // private EditorialEntity editorial;

   // @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<ReviewEntity> reviews = new ArrayList<>();

        /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
    * @return the comments
    */
    public ArrayList<String> getComments()
    {
        return comments;
    }

    /**
     * @param comments the lists of comments
     */
    public void setComments(ArrayList comments)
    {
        this.comments = comments;
    }

    /**
     * Add a comment to the event
     */
    public void addComment(String comment)
    {
        this.comments.add(comment);
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the image
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the image to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

     /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

        /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
