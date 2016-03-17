
package co.edu.uniandes.rest.cities.mocks;


import co.edu.uniandes.rest.cities.dtos.MultimediaDTO;
import co.edu.uniandes.rest.cities.dtos.ViajeroDTO;
import co.edu.uniandes.rest.cities.exceptions.PrimidLogicException;
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
public class MultimediaLogicMock {

	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ViajeroLogicMock.class.getName());

	// listado de ciudades
            private static ArrayList<MultimediaDTO> multimedia;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MultimediaLogicMock() {

    	if (multimedia == null) {
            multimedia = new ArrayList<>();
            multimedia.add(new MultimediaDTO(1L, "fotico","imagen","src/images/u1"));
            multimedia.add(new MultimediaDTO(2L, "videito","video","src/images/u2"));
            multimedia.add(new MultimediaDTO(3L, "musiquita","audio","src/images/u3"));
        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de archivos multimedia");
    	logger.info("multimedia" + multimedia );
}

    /**
	 * Obtiene el listado de archivos multimedia
	 * @return lista de archivos multimedia
	 * @throws PrimidLogicException cuando no existe la lista en memoria
	 */
    public List<MultimediaDTO> getMultimedia() throws PrimidLogicException {
    	if (multimedia == null) {
    		logger.severe("Error interno: lista de archivos multimedia no existe.");
    		throw new PrimidLogicException("Error interno: lista de archivos multimedia no existe.");
    	}

    	logger.info("retornando todos los archivos multimedia");
    	return multimedia;
    }

      /**
     * Obtiene un archivo multimedia
     * @param id identificador del archivo multimedia
     * @return archivo multimedia encontrado
     * @throws PrimidLogicException cuando el archivo multimedia no existe
     */
    public MultimediaDTO getArchivoMultimediaPorId(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud del viajero con id " + id);

    	// busca el archivo multimedia con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)){
            	logger.info("retornando archivo multimedia " + mult);
                return mult;
            }
        }

        // si no encuentra el archivo multimedia
        logger.severe("No existe archivo multimedia con ese id");
        throw new PrimidLogicException("No existe archivo multimedia con ese id");
    }

     /**
     * Agrega un archivo multimedia a la lista.
     * @param newMult archivo multimedia a adicionar
     * @throws PrimidLogicException cuando ya existe un archivo multimedia con el id suministrado
     * @return archivo multimedia agregado
     */
    public MultimediaDTO createArchivoMultimedia(MultimediaDTO newMult) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar archivo multimedia " + newMult);

    	// el nuevo archivo tiene id ?
    	if ( newMult.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (MultimediaDTO mult : multimedia) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(mult.getId(), newMult.getId())){
	            	logger.severe("Ya existe un archivo multimedia con ese id");
	                throw new PrimidLogicException("Ya existe un archivo multimedia con ese id");
	            }
	        }

	    // el nuevo archivo no tiene id ?
    	} else {

    		// genera un id para el archivo
    		logger.info("Generando id para el nuevo archivo");
    		long newId = 1;
	        for (MultimediaDTO mult : multimedia) {
	            if (newId <= mult.getId()){
	                newId =  mult.getId() + 1;
	            }
	        }
	        newMult.setId(newId);
    	}

        // agrega el archivo
    	logger.info("agregando archivo multimedia " + newMult);
        multimedia.add(newMult);
        return newMult;
    }

    /**
     * Actualiza los datos de un viajero
     * @param id identificador dl viajero a modificar
     * @param upViajero viajero a modificar
     * @return datos del viajero modificado
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */
    public MultimediaDTO updateArchivoMultimedia(Long id, MultimediaDTO updatedMult) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar archivo multimedia " + updatedMult);

    	// busca el viajero con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)) {

            	// modifica el archivo multimedia
            	mult.setId(updatedMult.getId());
                mult.setName(updatedMult.getName());

                // retorna el archivo multimedia modificado
            	logger.info("Modificando viajero " + mult);
                return mult;
            }
        }

        // Validacion: no encontró el archivo multimedia con ese id
        logger.severe("No existe un archivo multimedia con ese id");
        throw new PrimidLogicException("No existe un archivo multimedia con ese id");
    }

    /**
     * Elimina los datos de un archivo multimedia
     * @param id identificador del archivo multimedia a eliminar
     * @throws PrimidLogicException cuando no existe un archivo multimedia con el id suministrado
     */
    public void deleteArchivoMultimedia(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar viajero con id " + id);

    	// busca el archivo multimedia con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)) {

            	// elimina el archivo multimedia
            	logger.info("eliminando archivo multimedia " + mult);
                multimedia.remove(mult);
                return;
            }
        }

        // no encontró el archivo multimedia con ese id ?
        logger.severe("No existe un archivo multimedia con ese id");
        throw new PrimidLogicException("No existe un archivo multimedia con ese id");
    }
}
