/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.mocks;
import java.util.Date;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.PlanEventoDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author jd.torres11
 */
@Named
@ApplicationScoped
public class PlanEventoLogicMock {

	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(PlanEventoLogicMock.class.getName());

	// listado de planEventos
    private static ArrayList<PlanEventoDTO> planEventos;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public PlanEventoLogicMock() {

        Date fecha1=null;

    	if (planEventos == null) {
            planEventos = new ArrayList();
            planEventos.add(new PlanEventoDTO(1L, "Bogota", fecha1, fecha1));
            planEventos.add(new PlanEventoDTO(2L, "Cali", fecha1, fecha1));
            planEventos.add(new PlanEventoDTO(3L, "Medellin", fecha1, fecha1));
            planEventos.add(new PlanEventoDTO(4L, "Cartagena", fecha1, fecha1));
            planEventos.add(new PlanEventoDTO(5L, "San Andres", fecha1, fecha1 ));
            planEventos.add(new PlanEventoDTO(6L, "Pereira", fecha1, fecha1));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de planEventos");
    	logger.info("planEventos" + planEventos );
    }

	/**
	 * Obtiene el listado de planEventos.
	 * @return lista de planEventos
	 * @throws CityLogicException cuando no existe la lista en memoria
	 */
    public List<PlanEventoDTO> getplanEventos() throws PrimidLogicException {
    	if (planEventos == null) {
    		logger.severe("Error interno: lista de planEventos no existe.");
    		throw new PrimidLogicException("Error interno: lista de planEventos no existe.");
    	}

    	logger.info("retornando todas las planEventos");
    	return planEventos;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    public PlanEventoDTO getPlanEventos(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (PlanEventoDTO ciudad : planEventos) {
            if (Objects.equals(ciudad.getId(), id)){
            	logger.info("retornando ciudad " + ciudad);
                return ciudad;
            }
        }

        // si no encuentra la ciudad
        logger.severe("No existe ciudad con ese id");
        throw new PrimidLogicException("No existe ciudad con ese id");
    }

    /**
     * Agrega un plan ciudad a la lista.
     * @param nuevaCiudad plan ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return ciudad agregada
     */
    public PlanEventoDTO createPlanEventos(PlanEventoDTO nuevaCiudad) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar ciudad " + nuevaCiudad);

    	// la nueva ciudad tiene id ?
    	if ( nuevaCiudad.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (PlanEventoDTO ciudad : planEventos) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(ciudad.getId(), nuevaCiudad.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new PrimidLogicException("Ya existe una ciudad con ese id");
	            }
	        }

	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (PlanEventoDTO ciudad : planEventos) {
	            if (newId <= ciudad.getId()){
	                newId =  ciudad.getId() + 1;
	            }
	        }
	        nuevaCiudad.setId(newId);
    	}

        // agrega la ciudad
    	logger.info("agregando ciudad " + nuevaCiudad);
        planEventos.add(nuevaCiudad);
        return nuevaCiudad;
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public PlanEventoDTO updatePlanEventos(Long id, PlanEventoDTO updatedCity) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar ciudad " + updatedCity);

    	// busca la ciudad con el id suministrado
        for (PlanEventoDTO ciudad : planEventos) {
            if (Objects.equals(ciudad.getId(), id)) {

            	// modifica la ciudad
            	ciudad.setId(updatedCity.getId());
                ciudad.setName(updatedCity.getName());

                // retorna la ciudad modificada
            	logger.info("Modificando ciudad " + ciudad);
                return ciudad;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new PrimidLogicException("No existe una ciudad con ese id");
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public void deletePlanEventos(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (PlanEventoDTO ciudad : planEventos) {
            if (Objects.equals(ciudad.getId(), id)) {

            	// elimina la ciudad
            	logger.info("eliminando ciudad " + ciudad);
                planEventos.remove(ciudad);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new PrimidLogicException("No existe una ciudad con ese id");
    }
}
