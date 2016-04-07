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
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jd.torres11
 */
public class PlanCiudadEntity extends BaseEntity implements Serializable{

     @Temporal(TemporalType.DATE)
    private Date fechaLlegada;

       @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    @ManyToMany(mappedBy = "viajeros")
    private List<PlanCiudadEntity> planCiudades = new ArrayList<>();

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
