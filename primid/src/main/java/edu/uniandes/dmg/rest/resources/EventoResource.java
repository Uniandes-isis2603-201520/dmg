/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import edu.uniandes.dmg.rest.dtos.EventoDTO;
import edu.uniandes.dmg.rest.exceptions.EventoLogicException;
import edu.uniandes.dmg.rest.mocks.EventoLogicMock;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author karenlorenaosoriohenao
 */
@Path ("viajero")
@Produces("application/json")
public class EventoResource {

    //incluir dependencia desde el pomp
    @Inject
    EventoLogicMock eventoLogic;

    	/**
	 * Obtiene el listado de eventos.
	 * @return lista de eventos
	 * @throws EventoLogicException excepción retornada por la lógica
	 */
     @GET
    public List<EventoDTO> getEventos() throws EventoLogicException {
        return eventoLogic.getEventos();
    }

        /**
     * Obtiene un evento
     * @param id identificador dl evento
     * @return evento encontrada
     * @throws EventoLogicException cuando el evento no existe
     */
         @GET
         @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) throws EventoLogicException   {
        return eventoLogic.getEvento(id);
    }

    /**
     * Agrega un evento
     * @param evento evento a agregar
     * @return datos del evento a agregar
     * @throws EventoLogicException cuando ya existe un evento con el id suministrado
     */
         @POST
    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException  {
        return eventoLogic.createEvento(evento);
    }

        /**
     * Actualiza los datos de un evento
     * @param id identificador del evento a modificar
     * @param evento evento a modificar
     * @return datos del evento modificada
     * @throws EventoLogicException cuando no existe un evento con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long id, EventoDTO evento) throws EventoLogicException {
        return eventoLogic.updateEvento(id, evento);
    }

    /**
     * Elimina los datos de un evento
     * @param id identificador del evento a eliminar
     * @throws EventoLogicException cuando no existe un evento con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws EventoLogicException  {
        eventoLogic.deleteEvento(id);
    }

}
