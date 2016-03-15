/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.mocks;

import edu.uniandes.dmg.rest.dtos.ItinerarioDTO;
import edu.uniandes.dmg.rest.exceptions.ItinerarioLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author karenlorenaosoriohenao
 */
@ApplicationScoped
public class ItinerarioLogicMock {
    // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ItinerarioLogicMock.class.getName());
	
	// listado de Itinerarios
    private static ArrayList<ItinerarioDTO> Itinerarios;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ItinerarioLogicMock() {

    	if (Itinerarios == null) {
            Itinerarios = new ArrayList<>();
            Itinerarios.add(new ItinerarioDTO(1L,"name1","resumen1","2016/03/14","2016/03/15"));
            Itinerarios.add(new ItinerarioDTO(2L,"name2","resumen2","2016/04/14","2016/04/15"));
            Itinerarios.add(new ItinerarioDTO(3L,"name3","resumen3","2016/03/13","2016/03/15"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de Itinerarios");
    	logger.info("Itinerarios" + Itinerarios );
    }    
    
	/**
	 * Obtiene el listado de Itinerarios
	 * @return lista de Itinerarios
	 * @throws ItinerarioLogicException cuando no existe la lista en memoria  
	 */    
    public List<ItinerarioDTO> getItinerarios() throws ItinerarioLogicException {
    	if (Itinerarios == null) {
    		logger.severe("Error interno: lista de Itinerarios no existe.");
    		throw new ItinerarioLogicException("Error interno: lista de Itinerarios no existe.");    		
    	}
    	
    	logger.info("retornando todos los Itinerarios");
    	return Itinerarios;
    }

    /**
     * Obtiene un Itinerario
     * @param id identificador del Itinerario
     * @return Itinerario encontrado
     * @throws ItinerarioLogicException cuando el Itinerario no existe
     */
    public ItinerarioDTO getItinerario(Long id) throws ItinerarioLogicException {
    	logger.info("recibiendo solicitud del Itinerario con id " + id);
    	
    	// busca el Itinerario con el id suministrado
        for (ItinerarioDTO Itinerario : Itinerarios) {
            if (Objects.equals(Itinerario.getId(), id)){
            	logger.info("retornando itinerarios " + Itinerario);
                return Itinerario;
            }
        }
        
        // si no encuentrael Itinerario
        logger.severe("No existe Itinerario con ese id");
        throw new ItinerarioLogicException("No existe Itinerario con ese id");
    }

    /**
     * Agrega un Itinerario a la lista.
     * @param newItinerario Itinerario a adicionar
     * @throws ItinerarioLogicException cuando ya existe un Itinerario con el id suministrado
     * @return Itinerario agregado
     */
    public ItinerarioDTO createItinerario(ItinerarioDTO newItinerario) throws ItinerarioLogicException {
    	logger.info("recibiendo solicitud de agregar Itinerario " + newItinerario);
    	
    	// el nuevo Itinerario tiene id ?
    	if ( newItinerario.getId() != null ) {
	    	// busca el Itinerario con el id suministrado
	        for (ItinerarioDTO Itinerario : Itinerarios) {
	        	// si existe un Itinerario con ese id
	            if (Objects.equals(Itinerario.getId(), newItinerario.getId())){
	            	logger.severe("Ya existe un Itinerario con ese id");
	                throw new ItinerarioLogicException("Ya existe un Itinerario con ese id");
	            }
	        }
	        
	    // el nuevo Itinerario no tiene id ? 
    	} else {

    		// genera un id para el Itinerario
    		logger.info("Generando id para el nuevo Itinerario");
    		long newId = 1;
	        for (ItinerarioDTO Itinerario : Itinerarios) {
	            if (newId <= Itinerario.getId()){
	                newId =  Itinerario.getId() + 1;
	            }
	        }
	        newItinerario.setId(newId);
    	}
    	
        // agrega el Itinerario
    	logger.info("agregando Itinerario " + newItinerario);
        Itinerarios.add(newItinerario);
        return newItinerario;
    }

    /**
     * Actualiza los datos de un Itinerario
     * @param id identificador dl Itinerario a modificar
     * @param updatedItinerario Itinerario a modificar
     * @return datos del Itinerario modificado 
     * @throws ItinerarioLogicException cuando no existe un Itinerario con el id suministrado
     */
    public ItinerarioDTO updateItinerario(Long id, ItinerarioDTO updatedItinerario) throws ItinerarioLogicException {
    	logger.info("recibiendo solictud de modificar Itinerario " + updatedItinerario);
    	
    	// busca el Itinerario con el id suministrado
        for (ItinerarioDTO Itinerario : Itinerarios) {
            if (Objects.equals(Itinerario.getId(), id)) {
            	
            	// modifica el Itinerario
            	Itinerario.setId(updatedItinerario.getId());
                Itinerario.setName(updatedItinerario.getName());
                
                // retorna el Itinerario modificado
            	logger.info("Modificando Itinerario " + Itinerario);
                return Itinerario;
            }
        }
        
        // no encontró el Itinerario con ese id ?
        logger.severe("No existe un Itinerario con ese id");
        throw new ItinerarioLogicException("No existe un Itinerario con ese id");
    }

    /**
     * Elimina los datos de un Itinerario
     * @param id identificador del Itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe una ciudad con el id suministrado
     */
    public void deleteItinerario(Long id) throws ItinerarioLogicException {
    	logger.info("recibiendo solictud de eliminar Itinerario con id " + id);
    	
    	// busca el Itinerario con el id suministrado
        for (ItinerarioDTO Itinerario : Itinerarios) {
            if (Objects.equals(Itinerario.getId(), id)) {
            	
            	// elimina el Itinerario
            	logger.info("eliminando Itinerario " + Itinerario);
                Itinerarios.remove(Itinerario);
                return;
            }
        }

        // no encontró el Itinerario con ese id ?
        logger.severe("No existe un Itinerario con ese id");
        throw new ItinerarioLogicException("No existe un Itinerario con ese id");
    }
    
}
