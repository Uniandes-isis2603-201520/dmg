/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.resources;

import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.EventoDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.mocks.EventoLogicMock;
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
@Path ("eventos")
@Produces("application/json")
public class EventoResource {

    //incluir dependencia desde el pomp
    @Inject
    EventoLogicMock eventoLogic;

    	/**
	 * Obtiene el listado de eventos.
	 * @return lista de eventos
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
    public List<EventoDTO> getEventos() throws PrimidLogicException {
        return eventoLogic.getEventos();
    }

        /**
     * Obtiene un evento
     * @param id identificador dl evento
     * @return evento encontrada
     * @throws PrimidLogicException cuando el evento no existe
     */
         @GET
         @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) throws PrimidLogicException   {
        return eventoLogic.getEvento(id);
    }

    /**
     * Agrega un evento
     * @param evento evento a agregar
     * @return datos del evento a agregar
     * @throws PrimidLogicException cuando ya existe un evento con el id suministrado
     */
         @POST
    public EventoDTO createEvento(EventoDTO evento) throws PrimidLogicException  {
        return eventoLogic.createEvento(evento);
    }

        /**
     * Actualiza los datos de un evento
     * @param id identificador del evento a modificar
     * @param evento evento a modificar
     * @return datos del evento modificada
     * @throws PrimidLogicException cuando no existe un evento con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long id, EventoDTO evento) throws PrimidLogicException {
        return eventoLogic.updateEvento(id, evento);
    }

    /**
     * Elimina los datos de un evento
     * @param id identificador del evento a eliminar
     * @throws PrimidLogicException cuando no existe un evento con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws PrimidLogicException  {
        eventoLogic.deleteEvento(id);
    }

}
