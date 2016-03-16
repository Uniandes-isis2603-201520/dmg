/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.mocks;

import edu.uniandes.dmg.rest.dtos.TimelineDTO;
import edu.uniandes.dmg.rest.exceptions.PrimidLogicException;
import edu.uniandes.dmg.rest.exceptions.TimelineLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Mock del recurso Timelines (Mock del servicio REST)
 */
@Named
@Singleton
public class TimelineLogicMock {

    // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(TimelineLogicMock.class.getName());

	// listado de ciudades
    public static ArrayList<TimelineDTO> timelines;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public TimelineLogicMock() {

    	if (timelines == null) {

            ArrayList a= new ArrayList();
            ArrayList b= new ArrayList();

            String l1="nombre:visita museo,descripcion:Museo x...precio entrada...,fecha:01/02/2016";
            String l2="nombre:concierto,descripcion:concierto x...precio entrada...,lugar,fecha:05/06/2016";

          a.add(l1);
          a.add(l2);

          String l3="nombre:fiesta,descripcion:lugar x...precio entrada...,fecha:01/02/2016";
          String l4="nombre:caminata,descripcion:lugar x...precio entrada...,fecha:01/01/2016";

          b.add(l3);
          b.add(l4);



            timelines = new ArrayList<>();
            timelines.add(new TimelineDTO(1L, "itinerario1",a));
            timelines.add(new TimelineDTO(2L, "itinerario2",b));

        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("timelines" + timelines );
    }


    /**
	 * Obtiene el listado de personas.
	 * @return lista de ciudades
     * @throws edu.uniandes.dmg.rest.exceptions.TimelineLogicException
     */
    public List<TimelineDTO> getTimelines() throws PrimidLogicException {
    	if (timelines == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new PrimidLogicException("Error interno: lista de ciudades no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return timelines;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws edu.uniandes.dmg.rest.exceptions.TimelineLogicException
     * @throws CityLogicException cuando la ciudad no existe
     */
    public TimelineDTO getTimeline(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de timeline con id " + id);

    	// busca la ciudad con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)){
            	logger.info("retornando timeline " + timeline);
                return timeline;
            }
        }

        // si no encuentra la ciudad
        logger.severe("No existe ciudad con ese id");
        throw new PrimidLogicException("No existe ciudad con ese id");
    }

    /**
     * Agrega una ciudad a la lista.
     * @param newCity ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return ciudad agregada
     */
    public TimelineDTO createTimeline(TimelineDTO newTimeline) throws PrimidLogicException {
    	logger.info("recibiendo solicitud de agregar timeline " + newTimeline);

    	// la nueva ciudad tiene id ?
    	if ( newTimeline.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (TimelineDTO city : timelines) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(city.getId(), newTimeline.getId())){
	            	logger.severe("Ya existe un timeline con ese id");
	                throw new PrimidLogicException("Ya existe un timeline con ese id");
	            }
	        }

	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa el nuevo timeline");
    		long newId = 1;
	        for (TimelineDTO timeline : timelines) {
	            if (newId <= timeline.getId()){
	                newId =  timeline.getId() + 1;
	            }
	        }
	        newTimeline.setId(newId);
    	}

        // agrega la ciudad
    	logger.info("agregando timeline " + newTimeline);
        timelines.add(newTimeline);
        return newTimeline;
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public TimelineDTO updateTimeline(Long id, TimelineDTO updatedTimeline) throws PrimidLogicException {
    	logger.info("recibiendo solictud de modificar timeline " + updatedTimeline);

    	// busca la ciudad con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)) {

            	// modifica la ciudad
            	timeline.setId(updatedTimeline.getId());
               timeline.setName(updatedTimeline.getName());

                // retorna la ciudad modificada
            	logger.info("Modificando timeline " + timeline);
                return timeline;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe un timeline con ese id");
        throw new PrimidLogicException("No existe un timeline con ese id");
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public void deleteTimeline(Long id) throws PrimidLogicException {
    	logger.info("recibiendo solictud de eliminar timeline con id " + id);

    	// busca la ciudad con el id suministrado
        for (TimelineDTO timeline : timelines) {
            if (Objects.equals(timeline.getId(), id)) {

            	// elimina timeline
            	logger.info("eliminando timeline " + timeline);
                timelines.remove(timeline);
                return;
            }
        }

        // no encontró el timeline con ese id ?
        logger.severe("No existe un timeline con ese id");
        throw new PrimidLogicException("No existe un timeline con ese id");
    }


}
