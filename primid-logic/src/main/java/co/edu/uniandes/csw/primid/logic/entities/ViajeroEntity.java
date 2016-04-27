package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Entity
public class ViajeroEntity extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date birthDate;

    private Boolean estado;
    private String email;

    @OneToMany(mappedBy = "viajero")
    @PodamExclude
    private List<ItinerarioEntity> itinerarios = new ArrayList<>();

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<ItinerarioEntity> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<ItinerarioEntity> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public String getMail() {
        return email;
    }

    public Boolean getEstado() {
        return estado;
    }
}
