package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class CiudadEntity extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "ciudad")
    private ArrayList<EventoEntity> eventos = new ArrayList() ;

    private Double coordenadas;

    /**
     * @return the description
     */
    public Double getCoordenadas() {
        return coordenadas;
    }

    /**
     * @param coordenadas the description to set
     */
    public void setCoordenadas(double coordenadas) {
        this.coordenadas = coordenadas;
    }


}