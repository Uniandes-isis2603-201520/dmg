/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uniandes.dmg.rest.mocks;

import edu.uniandes.dmg.rest.dtos.MultimediaDTO;
import edu.uniandes.dmg.rest.exceptions.MultimediaLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
/**
 *
 * @author Fabio López
 */
public class MultimediaLogicMock {
    //Copiado igual al ejemplo
    // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(MultimediaLogicMock.class.getName());

	// listado de archivos multimedia
    private static ArrayList<MultimediaDTO> multimedia;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MultimediaLogicMock() {

    	if (multimedia == null) {
            multimedia = new ArrayList<>();
            multimedia.add(new MultimediaDTO(1L, "Foto1","imagen","ruta1"));
            multimedia.add(new MultimediaDTO(2L, "Musica1","audio","ruta2"));
            multimedia.add(new MultimediaDTO(3L, "Grabacion1","video","ruta3"));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de archivos multimedia");
    	logger.info("archivos multimedia" + multimedia );
    }

	/**
	 * Obtiene el listado de archivos multimedia.
	 * @return lista de archivos multimedia
         * @throws edu.uniandes.dmg.rest.exceptions.MultimediaLogicException
	 */
    public List<MultimediaDTO> getMultimedia() throws MultimediaLogicException {
    	if (multimedia == null) {
    		logger.severe("Error interno: lista de archivos multimedia no existe.");
    		throw new MultimediaLogicException("Error interno: lista de archivos multimedia no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return multimedia;
    }

    /**
     * Obtiene un archivo multimedia
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws edu.uniandes.dmg.rest.exceptions.MultimediaLogicException cuando el archivo no existe
     */
    public MultimediaDTO getMultimedia(Long id) throws MultimediaLogicException {
    	logger.info("recibiendo solicitud de ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)){
            	logger.info("retornando archivo multimedia " + mult);
                return mult;
            }
        }

        // si no encuentra el archivo multimedia
        logger.severe("No existe archivo multimedia con ese id");
        throw new MultimediaLogicException("No existe archivo multimedia con ese id");
    }

    /**
     * Agrega un archivo multimedia a la lista.
     * @param newMult archivo multimedia a adicionar
     * @throws MultimediaLogicException cuando ya existe un archivo multimedia con el id suministrado
     * @return archivo multimedia agregado
     */
    public MultimediaDTO createArchivoMultimedia(MultimediaDTO newMult) throws MultimediaLogicException {
    	logger.info("recibiendo solicitud de agregar archivo multimedia " + newMult);

    	// el nuevo archivo tiene id ?
    	if ( newMult.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (MultimediaDTO mult : multimedia) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(mult.getId(), newMult.getId())){
	            	logger.severe("Ya existe un archivo multimedia con ese id");
	                throw new MultimediaLogicException("Ya existe un archivo multimedia con ese id");
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
     * Actualiza los datos de un archivo multimedia
     * @param id identificador del archivo a modificar
     * @param updatedMult
     * @return datos del archivo modificado
     * @throws edu.uniandes.dmg.rest.exceptions.MultimediaLogicException cuando no existe un archivo con el id suministrado
     */
    public MultimediaDTO updateArchivoMultimedia(Long id, MultimediaDTO updatedMult) throws MultimediaLogicException {
    	logger.info("recibiendo solictud de modificar archivo multimedia " + updatedMult);

    	// busca la ciudad con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)) {

            	// modifica el archivo multimedia
            	mult.setId(updatedMult.getId());
                mult.setName(updatedMult.getName());
                mult.setRuta(updatedMult.getRuta());
                mult.setTipo(updatedMult.getTipo());
                mult.setVisible(updatedMult.getVisible());

                // retorna la ciudad modificada
            	logger.info("Modificando archivo " + mult);
                return mult;
            }
        }

        // no encontró el archivo multimedia con ese id ?
        logger.severe("No existe una archivo multimedia con ese id");
        throw new MultimediaLogicException("No existe una archivo multimedia con ese id");
    }

    /**
     * Elimina los datos de un archivo multimedia
     * @param id identificador del archivo multimedia a eliminar
     * @throws CityLogicException cuando no existe un archivo multimedia con el id suministrado
     */
    public void deleteArchivoMultimedia(Long id) throws MultimediaLogicException {
    	logger.info("recibiendo solictud de eliminar archivo multimedia con id " + id);

    	// busca el archivo multimedia con el id suministrado
        for (MultimediaDTO mult : multimedia) {
            if (Objects.equals(mult.getId(), id)) {

            	// elimina la ciudad
            	logger.info("eliminando archivo multimedia " + mult);
                multimedia.remove(mult);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new MultimediaLogicException("No existe un archivo multimedia con ese id");
    }
}
