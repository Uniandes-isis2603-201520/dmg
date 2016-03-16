/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.dtos;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class TimelineDTO {
     private Long id;
    private String name;
    private ArrayList eventos;


      /**
     * Constructor por defecto
     */
    public TimelineDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param id identificador de la ciudad
     * @param name nombre de la ciudad
     */
    public TimelineDTO(Long id, String name, ArrayList eventos) {
		super();
		this.id = id;
		this.name = name;
                this.eventos=eventos;
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

    /**
     * @return the name
     */
    public ArrayList getEventos() {
        return eventos;
    }

    /**
     * @param name the name to set
     */
    public void setEventos(ArrayList eventos) {
        this.eventos = eventos;

    }


     /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName()+ ", eventos : \"" + getEventos() + "\" }" ;
    }


}
