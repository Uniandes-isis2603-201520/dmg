/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos;

/**
 *
 * @author karenlorenaosoriohenao
 */
public class EventoDTO {

    private Long id;
    private String name;
    private String image;
    private String description;
    private String dateStarts;
    private String dateEnds;

    /**
     * Constructor por defecto
     */
    public EventoDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param id identificador del evento
     * @param name nombre del evento
     * @param image imagen del evento
     * @param description decripción del evento
     */
    public EventoDTO(Long id, String name, String image, String description, String dateStarts, String dateEnds) {
		super();
		this.id = id;
		this.name = name;
                this.image = image;
                this.description = description;
                this.dateStarts = dateStarts;
                this.dateEnds = dateEnds;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

        /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

            /**
     * @return the dateStarts
     */
    public String getDateStarts() {
        return dateStarts;
    }

    /**
     * @param dateStarts the dateStarts to set
     */
    public void setDateStarts(String dateStarts) {
        this.dateStarts = dateStarts;
    }

            /**
     * @return the dateEnds
     */
    public String getDateEnds() {
        return dateEnds;
    }

    /**
     * @param dateEnds the dateEnds to set
     */
    public void setDateEnds(String dateEnds) {
        this.dateEnds = dateEnds;
    }


    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + "\" }" ;
    }
}
