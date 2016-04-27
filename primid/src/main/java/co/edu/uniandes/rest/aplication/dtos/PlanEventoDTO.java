
/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.dtos;

import java.util.Date;

/**
 *
 * @author jd.torres11
 */
public class PlanEventoDTO {

    private Date fechaInicio;
    private Date fechaFin;
    private long id;
    private String name;

    /**
     * Constructor por defecto
     */
    public PlanEventoDTO() {

    }

    /**
     * Constructor
     */
    public PlanEventoDTO(long id, String name, Date fechaInicio, Date fechaFin) {

        super();
        this.id = id;
        this.name = name;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaInicio the date to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @param fechaFin the date to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + ", fechaInicio : \"" + getFechaInicio()
                + ", fechaInicio : \"" + getFechaFin() + " }";
    }

}
