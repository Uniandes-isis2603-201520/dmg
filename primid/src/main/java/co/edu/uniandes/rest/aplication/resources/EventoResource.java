/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.api.IEventoLogic;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.EventoDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
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
@Path ("ciudades/{id_Ciudad: \\d+}/eventos")
@Produces("application/json")
public class EventoResource {

    //incluir dependencia desde el pomp
    @Inject
    private IEventoLogic eventoLogic;

    	/**
	 * Obtiene el listado de eventos.
	 * @return lista de eventos
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
     @Path("ciudades/{id_Ciudad: \\d+}/eventos")
    public List<EventoDTO> getEventos() throws PrimidLogicException {
        return eventoLogic.getEventos();
    }


        /**
	 * Obtiene el listado de eventos del viajero.
	 * @return lista de eventos del viajero
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
//     @GET
//     @Path("viajeros/{id_Viajero: \\d+}/itinerarios/{id_Itinerario: \\d+}/planCiudades/{id_PlanCiudad: \\d+}/planEventos")
    public List<EventoDTO> getEventosViajero() throws PrimidLogicException {
        return eventoLogic.getEventosViajero();
    }

            /**
     * Obtiene un evento de un viajero
     * @param id identificador del evento
     * @return evento encontrada
     * @throws PrimidLogicException cuando el evento no existe
     */
         @GET
     @Path("viajeros/{id_Viajero: \\d+}/itinerarios/{id_Itinerario: \\d+}/planCiudades/{id_PlanCiudad: \\d+}/planEventos/{id_PlanEvento: \\d+}")
    public EventoDTO getEventoViajero(@PathParam("id_PlanEvento") Long id) throws PrimidLogicException   {
        return eventoLogic.getEventoViajero(id);
    }

        /**
     * Obtiene un evento
     * @param id identificador dl evento
     * @return evento encontrada
     * @throws PrimidLogicException cuando el evento no existe
     */
         @GET
     @Path("ciudades/eventos/{id_Evento: \\d+}")
    public EventoDTO getEvento(@PathParam("id_Evento") Long id) throws PrimidLogicException   {
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
     * Agrega un evento
     * @param evento evento a agregar
     * @return datos del evento a agregar
     * @throws PrimidLogicException cuando ya existe un evento con el id suministrado
     */
         @POST
    public EventoDTO createEventoViajero(EventoDTO evento) throws PrimidLogicException  {
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
