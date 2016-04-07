
package co.edu.uniandes.rest.aplication.mocks;



import co.edu.uniandes.rest.aplication.dtos.ViajeroDTO;
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
public class ViajeroLogicMock {

	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ViajeroLogicMock.class.getName());

	// listado de ciudades
            private static ArrayList<ViajeroDTO> viajeros;



    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ViajeroLogicMock() {

    	if (viajeros == null) {
            viajeros = new ArrayList();
            viajeros.add(new ViajeroDTO(1L, "Juan Perez","juan@perez.com","src/images/u1"));
            viajeros.add(new ViajeroDTO(2L, "Manuel","manuel@perez.com","src/images/u2"));
            viajeros.add(new ViajeroDTO(3L, "Pepita Perez","pepita@perez.com","src/images/u3"));
             viajeros.add(new ViajeroDTO(4L, "Armando esteban Quito","armando@banquitos.com","src/images/u4"));
              viajeros.add(new ViajeroDTO(5L, "Elsa Pato","Elsapayo@perez.com","src/images/u5"));
               viajeros.add(new ViajeroDTO(6L, "Elsa Pito","Elsapatero@perez.com","src/images/u6"));
        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de viajeros");
    	logger.info("viajeros" + viajeros );
}

    /**
	 * Obtiene el listado de viajeros
	 * @return lista de viajeros
	 * @throws PrimidLogicException cuando no existe la lista en memoria
	 */
    public List<ViajeroDTO> getViajeros() throws PrimidLogicException {
    	if (viajeros == null) {
    		logger.severe("Error interno: lista de viajeros no existe.");
    		throw new PrimidLogicException("Error interno: lista de viajeros no existe.");
    	}

    	logger.info("retornando todos los viajeros");
    	return viajeros;
    }

      /**
     * Obtiene un viajero
     * @param id identificador del viajero
     * @return viajero encontrado
     * @throws PrimidLogicException cuando el viajero no existe
     */
    public ViajeroDTO getViajeroPorId(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud del viajero con id " + id);

    	// busca el viajero con el id suministrado
        for (ViajeroDTO viajero : viajeros) {
            if (Objects.equals(viajero.getId(), id)){
            	logger.info("retornando viajero " + viajero);
                return viajero;
            }
        }

        // si no encuentra el viajero
        logger.severe("No existe viajero con ese id");
        throw new PrimidLogicException("No existe viajero con ese id");
    }

     /**
     * Agrega un Viajero a la lista.
     * @param newViajero Viajero a adicionar
     * @throws PrimidLogicException cuando ya existe un Viajero con el id suministrado
     * @return Viajero agregado
     */
    public ViajeroDTO createViajero(ViajeroDTO newViajero) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar Viajero " + newViajero);

    	// Validacion : el nuevo Viajero tiene id
    	if ( newViajero.getId() != null ) {
	    	// busca el viajero con el id suministrado
	        for (ViajeroDTO viajero : viajeros) {
	        	// si existe un viajero con ese id
	            if (Objects.equals(viajero.getId(), newViajero.getId())){
	            	logger.severe("Ya existe un viajero con ese id");
	                throw new PrimidLogicException("Ya existe un viajero con ese id");
	            }
	        }

	    // Validacion: el nuevo viajero no tiene id
    	} else {

    		// genera un id para el viajero
    		logger.info("Generando id para el nuevo viajero");
    		long newId = 1;
	        for (ViajeroDTO viajero : viajeros) {
	            if (newId <= viajero.getId()){
	                newId =  viajero.getId() + 1;
	            }
	        }
	        newViajero.setId(newId);
    	}

        // agrega el viajero
    	logger.info("agregando viajero " + newViajero);
        viajeros.add(newViajero);
        return newViajero;
    }

    /**
     * Actualiza los datos de un viajero
     * @param id identificador dl viajero a modificar
     * @param upViajero viajero a modificar
     * @return datos del viajero modificado
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */
    public ViajeroDTO updateViajero(Long id, ViajeroDTO upViajero) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar viajero " + upViajero);

    	// busca el viajero con el id suministrado
        for (ViajeroDTO viajero : viajeros) {
            if (Objects.equals(viajero.getId(), id)) {

            	// modifica el viajero
            	viajero.setId(upViajero.getId());
                viajero.setName(upViajero.getName());

                // retorna el viajero modificado
            	logger.info("Modificando viajero " + viajero);
                return viajero;
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
    public void deleteViajero(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar viajero con id " + id);

    	// busca el viajero con el id suministrado
        for (ViajeroDTO viajero : viajeros) {
            if (Objects.equals(viajero.getId(), id)) {

            	// elimina el viajero
            	logger.info("eliminando viajero " + viajero);
                viajeros.remove(viajero);
                return;
            }
        }

        // no encontró el viajero con ese id ?
        logger.severe("No existe un viajero con ese id");
        throw new PrimidLogicException("No existe un viajero con ese id");
    }
}
