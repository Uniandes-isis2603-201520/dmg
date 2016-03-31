package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CiudadEntity extends BaseEntity implements Serializable {

    private int id;
    private String name;
    private double coordenadas;
    private String description;

    @ManyToMany
    private List<AuthorEntity> authors = new ArrayList<>();

    @ManyToOne
    private EditorialEntity editorial;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviews = new ArrayList<>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public double getCoordenadas() {
        return coordenadas;
    }

    /**
     * @param coordenadas the description to set
     */
    public void setCoordenadas(double coordenadas) {
        this.coordenadas = coordenadas;
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

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public EditorialEntity getEditorial() {
        return editorial;
    }

    public void setEditorial(EditorialEntity editorial) {
        this.editorial = editorial;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}