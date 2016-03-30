
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.mocks;


import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.TimelineDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
// probando sonar2
/*
 * ViajeroLogicMock
 * Mock del recurso viajero (Mock del servicio REST)
 * Objeto de transferencia de datos de Viajeros.
 * @author jd.torres11
 */
@Named
@ApplicationScoped
public class TimelineLogicMock {

	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(TimelineLogicMock.class.getName());

	// listado de ciudades
            private static ArrayList<TimelineDTO> timelines;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public TimelineLogicMock() {

    	if (timelines == null) {
            timelines = new ArrayList();

            ArrayList a= new ArrayList();
            a.add("descripcion:Concierto...lugar..precio..,fecha:01/02/2016");
            a.add("descripcion:Visita Museo...lugar..precio..,fecha:03/04/2016");

             ArrayList b= new ArrayList();
            b.add("descripcion:Caminata...lugar..precio..,fecha:03/05/2016");
            b.add("descripcion:Fiesta...lugar..precio..,fecha:09/09/2016");


            timelines.add(new TimelineDTO(1L, "itinerario1",a));
            timelines.add(new TimelineDTO(2L, "itinerario2",b));

        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de timelines");
    	logger.info("timelines" + timelines );
}

    /**
	 * Obtiene el listado de viajeros
	 * @return lista de viajeros
	 * @throws PrimidLogicException cuando no existe la lista en memoria
	 */
    public List<TimelineDTO> getTimelines() throws PrimidLogicException {
    	if (timelines == null) {
    		logger.severe("Error interno: lista de timelines no existe.");
    		throw new PrimidLogicException("Error interno: lista de timelines no existe.");
    	}

    	logger.info("retornando todos los timelines");
    	return timelines;
    }

      /**
     * Obtiene un viajero
     * @param id identificador del viajero
     * @return viajero encontrado
     * @throws PrimidLogicException cuando el viajero no existe
     */
    public TimelineDTO getTimelinePorId(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud del timeline con id " + id);

    	// busca el viajero con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)){
            	logger.info("retornando timeline " + timeline);
                return timeline;
            }
        }

        // si no encuentra el viajero
        logger.severe("No existe timeline con ese id");
        throw new PrimidLogicException("No existe timeline con ese id");
    }

     /**
     * Agrega un Viajero a la lista.
     * @param newTimeline Viajero a adicionar
     * @throws PrimidLogicException cuando ya existe un Viajero con el id suministrado
     * @return Viajero agregado
     */
    public TimelineDTO createTimeline(TimelineDTO newTimeline) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar Timline " + newTimeline);

    	// Validacion : el nuevo Viajero tiene id
    	if ( newTimeline.getId() != null ) {
	    	// busca el viajero con el id suministrado
	        for (TimelineDTO timeline :timelines) {
	        	// si existe un viajero con ese id
	            if (Objects.equals(timeline.getId(), newTimeline.getId())){
	            	logger.severe("Ya existe un viajero con ese id");
	                throw new PrimidLogicException("Ya existe un viajero con ese id");
	            }
	        }

	    // Validacion: el nuevo viajero no tiene id
    	} else {

    		// genera un id para el viajero
    		logger.info("Generando id para el nuevo viajero");
    		long newId = 1;
	        for (TimelineDTO timeline : timelines) {
	            if (newId <= timeline.getId()){
	                newId =  timeline.getId() + 1;
	            }
	        }
	        newTimeline.setId(newId);
    	}

        // agrega el viajero
    	logger.info("agregando timeline " + newTimeline);
        timelines.add(newTimeline);
        return newTimeline;
    }

    /**
     * Actualiza los datos de un viajero
     * @param id identificador dl viajero a modificar
     * @param upViajero viajero a modificar
     * @return datos del viajero modificado
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */
    public TimelineDTO updateTimeline(Long id, TimelineDTO upTimeline) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar viajero " + upTimeline);

    	// busca el viajero con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)) {

            	// modifica el viajero
            	timeline.setId(upTimeline.getId());
                timeline.setName(upTimeline.getName());

                // retorna el viajero modificado
            	logger.info("Modificando viajero " + timeline);
                return timeline;
            }
        }

        // Validacion: no encontró el viajero con ese id
        logger.severe("No existe un viajero con ese id");
        throw new PrimidLogicException("No existe un viajero con ese id");
    }

    /**
     * Elimina los datos de un viajero
     * @param id identificador del viajero a eliminar
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */
    public void deleteTimeline(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar viajero con id " + id);

    	// busca el viajero con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)) {

            	// elimina el viajero
            	logger.info("eliminando viajero " + timeline);
                timelines.remove(timeline);
                return;
            }
        }

        // no encontró el viajero con ese id ?
        logger.severe("No existe un viajero con ese id");
        throw new PrimidLogicException("No existe un viajero con ese id");
    }
}
