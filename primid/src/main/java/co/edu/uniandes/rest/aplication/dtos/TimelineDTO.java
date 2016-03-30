/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos;

import java.util.ArrayList;

/**
 *
 * @author s.gonzalez22
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

    /*
     * Constructor con parámetros.
     * @param id identificador del viajero
     * @param name nombre del viajero
     * @param mail mail del viajero
     * @param rutaImg imagen del viajero
     */
    public TimelineDTO(Long id, String name, ArrayList eventos) {
		super();
		this.id = id;
		this.name = name;
                this.eventos = eventos;

	}
    /*
     * @return el id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id el id del viajero
     */
    public void setId(Long id) {
        this.id = id;
    }
    /*
     * @return el name
     */
    public String getName() {
        return name;
    }
     /**
     * @param name el name del viajero
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     * @return el mail
     */
    public ArrayList getEventos() {
        return eventos;
    }
    /**
     * @param mail el mail del viajero
     */
    public void setEventos(ArrayList eventos) {
        this.eventos = eventos;
    }

    public String getEvents()
    {
        String e="";

        for (int i=0;i<eventos.size();i++)
        {
         String a = (String) eventos.get(i);

         e+=","+a;
        }
        return e;
    }
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + ", mail : \"" + getEvents() +"\" }" ;
    }

}
