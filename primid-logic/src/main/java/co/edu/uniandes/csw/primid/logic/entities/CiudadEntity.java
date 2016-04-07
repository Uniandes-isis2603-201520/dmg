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
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Entity
public class CiudadEntity extends BaseEntity implements Serializable {

    private double coordenadas;
   
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

    
}