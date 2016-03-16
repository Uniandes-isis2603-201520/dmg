/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;


import edu.uniandes.dmg.rest.dtos.TimelineDTO;
import edu.uniandes.dmg.rest.exceptions.PrimidLogicException;
import edu.uniandes.dmg.rest.exceptions.TimelineLogicException;
import edu.uniandes.dmg.rest.mocks.TimelineLogicMock;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Sebastian
 */
@Path ("timelines")
@Produces("application/json")
@RequestScoped
public class TimelineResource {

    @Inject
	TimelineLogicMock timelineLogic;

	/**
	 * Obtiene el listado de personas.
	 * @return lista de ciudades
     * @throws edu.uniandes.dmg.rest.exceptions.TimelineLogicException
	 * @throws CityLogicException excepción retornada por la lógica
	 */
    @GET
    public List<TimelineDTO> getTimelines() throws PrimidLogicException {
        return timelineLogic.getTimelines();
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("{id: \\d+}")
    public TimelineDTO getCity(@PathParam("id") Long id) throws PrimidLogicException {
        return timelineLogic.getTimeline(id);
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public TimelineDTO createTimeline(TimelineDTO timeline) throws PrimidLogicException {
        return timelineLogic.createTimeline(timeline);
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public TimelineDTO updateTimeline(@PathParam("id") Long id, TimelineDTO timeline) throws PrimidLogicException {
        return timelineLogic.updateTimeline(id, timeline);
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) throws PrimidLogicException {
    	timelineLogic.deleteTimeline(id);
    }

    

}
