
package edu.uniandes.dmg.rest.dtos;

/*
 * Objeto de transferencia de datos de Itinerarioss.
 * @author la.mesa10
 */
public class ItinerarioDTO {

    private Long id;
    private String name;
    private String resumen;
    private String fechaInicio;
    private String fechaFin;

    /**
     * Constructor por defecto
     */
    public ItinerarioDTO() {
	}

    /*
     * Constructor con parámetros.
     * @param id identificador del itinerario
     * @param name nombre del itinerario
     * @param resumen, resumen del itinerario
     * @param fechaInicio, fecha inicio
    * @param fechaFin, fecha fin
     */
    public ItinerarioDTO(Long id, String name, String resumen,String fechaInicio, String fechaFin) {
		super();
		this.id = id;
		this.name = name;
                this.resumen = resumen;
                this.fechaInicio =fechaInicio;
                this.fechaFin    = fechaFin;
	}
    /*
     * @return el id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id el id del Itinerario
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
     * @param name el name del Itinerario
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     * @return el resumen
     */
    public String getResumen() {
        return resumen;
    }
    /**
     * @param resumen el resumen del itinerario
     */
    public void setResumen(String resumen) {
        this.resumen =resumen;
    }
      /*
     * @return la fecha de inicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }
    /**
     * @param fechaInicio, fecha en que inicia un itinerario
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
      /*
     * @return la fecha final
     */
    public String getFechaFin() {
        return fechaInicio;
    }
    /**
     * @param fechaFin, fecha en que termina un itinerario
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
