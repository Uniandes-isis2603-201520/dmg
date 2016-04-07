/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.api.IEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.EventoEntity;
import co.edu.uniandes.rest.aplication.converters.EventoConverter;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.rest.aplication.dtos.EventoDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author karenlorenaosoriohenao
 */
@Path ("ciudades/{id_Ciudad: \\d+}/eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoResource {

    private static final Logger logger = Logger.getLogger(EventoResource.class.getName());

    //incluir dependencia desde el pomp
    @Inject
    private IEventoLogic eventoLogic;

    	/**
	 * Obtiene el listado de eventos.
	 * @return lista de eventos
	 * @throws BusinessLogicException excepción retornada por la lógica
	 */
     @GET
    public List<EventoDTO> getEventos() throws BusinessLogicException {
        logger.info("Se ejecuta método getEventos");
        return EventoConverter.listEntity2DTO(eventoLogic.getEventos());
    }

        /**
     * Obtiene un evento
     * @param id identificador dl evento
     * @return evento encontrada
     * @throws BusinessLogicException cuando el evento no existe
     */
         @GET
     @Path("{id_Evento: \\d+}")
    public EventoDTO getEvento(@PathParam("id_Evento") Long id) throws BusinessLogicException   {
        logger.log(Level.INFO, "Se ejecuta método geEvento con id={0}", id);
        return EventoConverter.fullEntity2DTO(eventoLogic.getEvento(id));
    }

        /**
     * Agrega un evento
     * @param dto evento a agregar
     * @return datos del evento a agregar
     * @throws BusinessLogicException cuando ya existe un evento con el id suministrado
     */
         @POST
    public EventoDTO createEvento(EventoDTO dto) throws BusinessLogicException  {

        logger.info("Se ejecuta método createEvento");
        EventoEntity entity = EventoConverter.fullDTO2Entity(dto);
        EventoEntity newEntity;
        newEntity = eventoLogic.createEvento(entity);
        return EventoConverter.fullEntity2DTO(newEntity);
    }

        /**
     * Actualiza los datos de un evento
     * @param id identificador del evento a modificar
     * @param dto evento a modificar
     * @return datos del evento modificada
     * @throws BusinessLogicException cuando no existe un evento con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long id, EventoDTO dto) throws BusinessLogicException {
        logger.log(Level.INFO, "Se ejecuta método updatEvento con id={0}", id);
        EventoEntity entity = EventoConverter.fullDTO2Entity(dto);
        entity.setId(id);
        EventoEntity oldEntity = eventoLogic.getEvento(id);
        entity.setComments(oldEntity.getComments());
        EventoEntity savedBook = eventoLogic.updateEvento(entity);
        return EventoConverter.fullEntity2DTO(savedBook);
    }

    /**
     * Elimina los datos de un evento
     * @param id identificador del evento a eliminar
     * @throws BusinessLogicException cuando no existe un evento con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws BusinessLogicException  {
         logger.log(Level.INFO, "Se ejecuta método deleteEvento con id={0}", id);
        eventoLogic.deleteEvento(id);
    }

}
