/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos;

/**
 *
 * @author fa.lopez10
 */
public class MultimediaDTO {

    private long id;
    private String name;
    private String tipo;
    private Boolean visible;
    private String ruta;

    public final static String VIDEO="video";
    public final static String AUDIO="audio";
    public final static String IMAGEN="imagen";

    /**
     * Constructor por defecto
     */
    public MultimediaDTO() {
	}

    /*
     * Constructor con parámetros.
     * @param id identificador del viajero
     * @param name nombre del viajero
     * @param mail mail del viajero
     * @param rutaImg imagen del viajero
     */
    public MultimediaDTO(long id, String name, String tipo,String ruta) {
		super();
		this.id = id;
		this.name = name;
                this.tipo = tipo;
                this.visible = true;
                this.ruta = ruta;
	}
    /*
     * @return el id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id el id del archivo multimedia
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
     * @param name el name del archivo multimedia
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     * @return el tipo(ARCHIVO,VIDEO, AUDIO)
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * @param mail el mail del viajero
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
      /*
     * @return el estado
     */
    public Boolean getVisible() {
        return visible;
    }
    /**
     * @param estado el estado de la cuenta
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    /*
     * @return la ruta
     */
    public String getRuta() {
        return ruta;
    }
     /**
     * @param name el name del archivo multimedia
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
     /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + ", tipo : \"" + getTipo() + ", visible : \"" +getVisible() + ", ruta : \"" +getRuta() +"\" }" ;
    }
}
