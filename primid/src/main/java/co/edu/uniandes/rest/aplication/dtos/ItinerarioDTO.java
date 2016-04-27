/*
 * ViajeroDTO
 * Objeto de transferencia de datos de Viajeros.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 * @author la.mesa10
 */
package co.edu.uniandes.rest.aplication.dtos;

import java.util.Date;

/*
 * Objeto de transferencia de datos de Viajeros.
 * @author la.mesa10
 */
public class ItinerarioDTO {

    private Long id;
    //TODO
    private Long idViajero;
    private String resumen;
    private Date fechaInicio;
    private Date fechaFin;
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
    public ItinerarioDTO(Long id, String resumen, Date fechaInicio, Date fechaFin, String rutaImg, Long idViajero) {
        super();
        this.id = id;
        this.resumen = resumen;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.rutaImg = rutaImg;
        this.idViajero = idViajero;
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
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio el fechaInicio del viajero
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /*
     * @return la fecha final
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /*
     * @return la ruta de la imagen
     */
    public String getRutaImg() {
        return rutaImg;
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
        return "{ id : " + getId() + ", resumen : \"" + getResumen() + ", fechaInicio : \"" + getFechaInicio() + ", fechaFin : \"" + getFechaFin() + "\" }";
    }

}
