/*
 *ViajeroResource.java
 * Clase que representa el viajero "/timeline"
 * Implementa varios m�todos para manipular los viajeros
 */
package co.edu.uniandes.rest.aplication.resources;


import co.edu.uniandes.csw.primid.logic.api.ITimelineLogic;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.TimelineDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * Clase que implementa el recurso REST correspondiente a "timeline".
 *
 * Note que la aplicaci�n (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "viajeros".
 * Al ejecutar la aplicaci�n, el recurso ser� accesibe a trav�s de la
 * ruta "/api/viajero"
 * @author s.gonzalez22
 */
@Path ("viajeros/{id_Viajero:\\d+}/itinerarios/{id_Itinerario:\\d+}/timeline")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TimelineResource {

 //incluir dependencia desde el pom
    @Inject
    private ITimelineLogic timelineLogic;

    	/**
	 * Obtiene el listado de timelines de los itinerarios de un viajero.
	 * @return lista de viajeros
	 * @throws PrimidLogicException excepci�n retornada por la l�gica
	 */
     @GET
    public List<TimelineDTO> getTimelines() throws PrimidLogicException {
        return timelineLogic.getTimelines();
    }

    /**
     * Obtiene un timeline de un itinerario
     * @param id identificador del timeline
     * @return Timeline encontrado
     * @throws PrimidLogicException cuando el tineline no existe
     */
         @GET
         @Path("{id: \\d+}")
    public TimelineDTO getTimeline(@PathParam("id") Long id) throws PrimidLogicException   {
        return timelineLogic.getTimelinePorId(id);
    }

     /**
     * Agrega un viajero
     * @param viajero viajero a agregar
     * @return datos del viajero a agregar
     * @throws PrimidLogicException cuando ya existe un viajero con el id suministrado
     */
         @POST
    public TimelineDTO createTimelines(TimelineDTO timeline) throws PrimidLogicException  {
        return timelineLogic.createTimeline(timeline);
    }


        /**
     * Actualiza los datos de un viajero
     * @param id identificador del viajero a modificar
     * @param viajero viajero a modificar
     * @return datos del viajero modificada
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public TimelineDTO updateTimeline(@PathParam("id") Long id, TimelineDTO timeline) throws PrimidLogicException {
        return timelineLogic.updateTimeline(id, timeline);
    }

    /**
     * Elimina los datos de un viajero
     * @param id identificador del viajero a eliminar
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteTimeline(@PathParam("id") Long id) throws PrimidLogicException  {
        timelineLogic.deleteTimeline(id);
    }

}

