package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class CiudadEntity extends BaseEntity implements Serializable {

    private Integer coordenadas;

    @OneToMany(mappedBy = "ciudad")
    @PodamExclude
    private List<EventoEntity> eventos = new ArrayList<>();

    /**
     * @return the description
     */
    public Integer getCoordenadas() {
        return coordenadas;
    }

    /**
     * @param coordenadas the description to set
     */
    public void setCoordenadas(Integer coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<EventoEntity> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoEntity> eventos) {
        this.eventos = eventos;
    }

}
