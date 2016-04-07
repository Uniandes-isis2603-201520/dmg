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



    private double coordenadas;
    private String description;

    @ManyToMany
    private List<CiudadEntity> authors = new ArrayList<>();

    @ManyToOne
    private CiudadEntity editorial;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CiudadEntity> reviews = new ArrayList<>();






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

    public List<CiudadEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<CiudadEntity> authors) {
        this.authors = authors;
    }

    public CiudadEntity getEditorial() {
        return editorial;
    }

    public void setEditorial(CiudadEntity editorial) {
        this.editorial = editorial;
    }

    public List<CiudadEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<CiudadEntity> reviews) {
        this.reviews = reviews;
    }
}