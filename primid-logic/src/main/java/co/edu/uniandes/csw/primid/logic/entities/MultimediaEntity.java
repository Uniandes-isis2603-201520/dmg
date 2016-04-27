package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class MultimediaEntity extends BaseEntity implements Serializable {

    private String tipo;
    private String ruta;
//    Relaciones con planEvento, planCiudad
    @ManyToOne
    @PodamExclude
    private PlanEventoEntity planEvento;

    @ManyToOne
    @PodamExclude
    private PlanCiudadEntity planCiudad;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     *
     * @return PlanEventoEntity
     */
    public PlanEventoEntity getPlanEvento() {
        return planEvento;
    }

    /**
     *
     * @param planEvento
     */
    public void setPlanEvento(PlanEventoEntity planEvento) {
        this.planEvento = planEvento;
    }

    /**
     *
     * @return PlanCiudadEntity
     */
    public PlanCiudadEntity getPlanCiudad() {
        return planCiudad;
    }

    /**
     *
     * @param planCiudad
     */
    public void setPlanCiudad(PlanCiudadEntity planCiudad) {
        this.planCiudad = planCiudad;
    }

}
