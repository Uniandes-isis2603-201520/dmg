
package co.edu.uniandes.rest.aplication.mocks;


//import co.edu.uniandes.rest.cities.dtos.ItinerarioDTO;
import co.edu.uniandes.rest.aplication.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/*
 * ItinerarioLogicMock
 * Mock del recurso itinerario (Mock del servicio REST)
 * Objeto de transferencia de datos de Itinerarios.
 * @author la.mesa10
 */
@Named
@ApplicationScoped
public class ItinerarioLogicMock {

	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ItinerarioLogicMock.class.getName());

	// listado de ciudades
            private static ArrayList<ItinerarioDTO> itinerarios;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ItinerarioLogicMock() {

    	if (itinerarios == null) {
            itinerarios = new ArrayList();
            //itinerarios.add(new ItinerarioDTO(1L, "Vacaciones en familia","2016/03/17","2016/03/19","resources/images/Intinerario1.jpg",1L));
            //itinerarios.add(new ItinerarioDTO(2L, "Vacaciones en Estambul","2016/03/18","2016/03/20","resources/images/Intinerario2.jpg",1L));
            //itinerarios.add(new ItinerarioDTO(3L, "Visita a la familia","2016/03/19","2016/03/21","resources/images/Intinerario3.jpg",1L));
            //itinerarios.add(new ItinerarioDTO(3L, "Visita a Shadow Moses","2016/03/20","2016/03/22","resources/images/Intinerario3.jpg",2L));
            //itinerarios.add(new ItinerarioDTO(3L, "Vacaciones en Wakanda","2016/03/21","2016/03/23","resources/images/Intinerario2.jpg",3L));
        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de itinerarios");
    	logger.info("itinerarios" + itinerarios );
}

    /**
	 * Obtiene el listado de itinerarios
     * @param idViajero
	 * @return lista de itinerarios
	 * @throws PrimidLogicException cuando no existe la lista en memoria
	 */
    public List<ItinerarioDTO> getItinerarios(Long idViajero) throws PrimidLogicException {
    	if (itinerarios == null) {
    		logger.severe("Error interno: lista de itinerarios no existe.");
    		throw new PrimidLogicException("Error interno: lista de itinerarios no existe.");
    	}

    	logger.info("retornando todos los itinerarios del viajero");
        List<ItinerarioDTO> itinerariosViajero = new ArrayList ();
        for (int i = 0 ; i< itinerarios.size();i++) {
           ItinerarioDTO itinerario = itinerarios.get(i);
           if(Objects.equals(idViajero, itinerario.getIdViajero()))
           {
               itinerariosViajero.add(itinerario);
           }
        }
    	return itinerariosViajero;
    }

      /**
     * Obtiene un itinerario
     * @param id identificador del itinerario
     * @return itinerario encontrado
     * @throws PrimidLogicException cuando el itinerario no existe
     */
    public ItinerarioDTO getItinerarioPorId(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud del itinerario con id " + id);

    	// busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)){
            	logger.info("retornando itinerario " + itinerario);
                return itinerario;
            }
        }

        // si no encuentra el itinerario
        logger.severe("No existe itinerario con ese id");
        throw new PrimidLogicException("No existe itinerario con ese id");
    }

     /**
     * Agrega un Itinerario a la lista.
     * @param newItinerario Itinerario a adicionar
     * @throws PrimidLogicException cuando ya existe un Itinerario con el id suministrado
     * @return Itinerario agregado
     */
    public ItinerarioDTO createItinerario(ItinerarioDTO newItinerario) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar Itinerario " + newItinerario);

    	// Validacion : el nuevo Itinerario tiene id
    	if ( newItinerario.getId() != null ) {
	    	// busca el itinerario con el id suministrado
	        for (ItinerarioDTO itinerario : itinerarios) {
	        	// si existe un itinerario con ese id
	            if (Objects.equals(itinerario.getId(), newItinerario.getId())){
	            	logger.severe("Ya existe un itinerario con ese id");
	                throw new PrimidLogicException("Ya existe un itinerario con ese id");
	            }
	        }

	    // Validacion: el nuevo itinerario no tiene id
    	} else {

    		// genera un id para el itinerario
    		logger.info("Generando id para el nuevo itinerario");
    		long newId = 1;
	        for (ItinerarioDTO itinerario : itinerarios) {
	            if (newId <= itinerario.getId()){
	                newId =  itinerario.getId() + 1;
	            }
	        }
	        newItinerario.setId(newId);
    	}

        // agrega el itinerario
    	logger.info("agregando itinerario " + newItinerario);
        itinerarios.add(newItinerario);
        return newItinerario;
    }

    /**
     * Actualiza los datos de un itinerario
     * @param id identificador dl itinerario a modificar
     * @param upItinerario itinerario a modificar
     * @return datos del itinerario modificado
     * @throws PrimidLogicException cuando no existe un itinerario con el id suministrado
     */
    public ItinerarioDTO updateItinerario(Long id, ItinerarioDTO upItinerario) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar itinerario " + upItinerario);

    	// busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

            	// modifica el itinerario
            	itinerario.setId(upItinerario.getId());
                itinerario.setResumen(upItinerario.getResumen());

                // retorna el itinerario modificado
            	logger.info("Modificando itinerario " + itinerario);
                return itinerario;
            }
        }

        // Validacion: no encontró el itinerario con ese id
        logger.severe("No existe un itinerario con ese id");
        throw new PrimidLogicException("No existe un itinerario con ese id");
    }

    /**
     * Elimina los datos de un itinerario
     * @param id identificador del itinerario a eliminar
     * @throws PrimidLogicException cuando no existe un itinerario con el id suministrado
     */
    public void deleteItinerario(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar itinerario con id " + id);

    	// busca el itinerario con el id suministrado
        for (ItinerarioDTO itinerario : itinerarios) {
            if (Objects.equals(itinerario.getId(), id)) {

            	// elimina el itinerario
            	logger.info("eliminando itinerario " + itinerario);
                itinerarios.remove(itinerario);
                return;
            }
        }

        // no encontró el itinerario con ese id ?
        logger.severe("No existe un itinerario con ese id");
        throw new PrimidLogicException("No existe un itinerario con ese id");
    }
}
