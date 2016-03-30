/*
 * ViajeroDTO
 * Objeto de transferencia de datos de Viajeros.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 * @author la.mesa10
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos;

/*
 * Objeto de transferencia de datos de Viajeros.
 * @author la.mesa10
 */
public class ItinerarioDTO {

    private Long id;
    private Long idViajero;
    private String resumen;
    private String fechaInicio;
    private String fechaFin;
    private String rutaImg;

    /**
     * Constructor por defecto
     */
    public ItinerarioDTO() {
	}

    /*
     * Constructor con parámetros.
     * @param id identificador del viajero
     * @param resumen nombre del viajero
     * @param fechaInicio fechaInicio del viajero
     * @param rutaImg imagen del viajero
     */
    public ItinerarioDTO(Long id, String resumen, String fechaInicio,String fechaFin,String rutaImg,Long idViajero) {
		super();
		this.id = id;
		this.resumen = resumen;
                this.fechaInicio = fechaInicio;
                this.fechaFin=fechaFin;
                this.rutaImg = rutaImg;
                this.idViajero=idViajero;
	}
    /*
     * @return el id
     */
    public Long getId() {
        return id;
    }
    /*
     * @return el id
     */
    public Long getIdViajero() {
        return idViajero;
    }
    /**
     * @param id el id del viajero
     */
    public void setId(Long id) {
        this.id = id;
    }
    /*
     * @return el resumen
     */
    public String getResumen() {
        return resumen;
    }
     /**
     * @param resumen el resumen del viajero
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    /*
     * @return el fechaInicio
     */
    public String getfechaInicio() {
        return fechaInicio;
    }
    /**
     * @param fechaInicio el fechaInicio del viajero
     */
    public void setfechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
      /*
     * @return la fecha final
     */
    public String getFechaFin() {
        return fechaFin;
    }
    /**
     * @param fechaFin estado final de la cuenta
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
      /*
     * @return la ruta de la imagen
     */
    public String getRutaImg()
    {
        return fechaFin;
    }
    /**
     * @param rutaImg ruta con la imagem
     */
    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }


     /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", resumen : \"" + getResumen() + ", fechaInicio : \"" + getfechaInicio() + ", fechaFin : \"" +getFechaFin() +"\" }" ;
    }
}
