/*
 * ViajeroDTO
 * Objeto de transferencia de datos de Viajeros.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 * @author jd.torres11
 */
package edu.uniandes.dmg.rest.dtos;

/*
 * Objeto de transferencia de datos de Viajeros.
 * @author jd.torres11
 */
public class ViajeroDTO {

    private Long id;
    private String name;
    private String mail;
    private Boolean activo;
    private String rutaImg;

    /**
     * Constructor por defecto
     */
    public ViajeroDTO() {
	}

    /*
     * Constructor con parámetros.
     * @param id identificador del viajero
     * @param name nombre del viajero
     * @param mail mail del viajero
     * @param rutaImg imagen del viajero
     */
    public ViajeroDTO(Long id, String name, String mail,String rutaImg) {
		super();
		this.id = id;
		this.name = name;
                this.mail = mail;
                this.activo = true;
                this.rutaImg = rutaImg;
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
    public String getMail() {
        return mail;
    }
    /**
     * @param mail el mail del viajero
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
      /*
     * @return el estado
     */
    public Boolean getEstado() {
        return activo;
    }
    /**
     * @param estado el estado de la cuenta
     */
    public void setEstado(Boolean estado) {
        this.activo = estado;
    }
     /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + ", mail : \"" + getMail() + ", estado : \"" +getEstado() +"\" }" ;
    }
}
