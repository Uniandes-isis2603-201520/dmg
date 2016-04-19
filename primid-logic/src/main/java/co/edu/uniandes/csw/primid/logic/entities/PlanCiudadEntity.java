/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jd.torres11
 */
@Entity
public class PlanCiudadEntity extends BaseEntity implements Serializable{

     @Temporal(TemporalType.DATE)
    private Date fechaLlegada;

     @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    @ManyToOne
    private ItinerarioEntity itinerario;

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }



}
