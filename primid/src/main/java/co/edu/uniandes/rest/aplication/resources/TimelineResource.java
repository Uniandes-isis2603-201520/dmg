/*
 *ViajeroResource.java
 * Clase que representa el viajero "/timeline"
 * Implementa varios métodos para manipular los viajeros
 */
package co.edu.uniandes.rest.aplication.resources;


import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.TimelineDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.mocks.TimelineLogicMock;
import co.edu.uniandes.rest.aplication.mocks.ViajeroLogicMock;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/*
 * Clase que implementa el recurso REST correspondiente a "viajeros".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "viajeros".
 * Al ejecutar la aplicación, el recurso será accesibe a través de la
 * ruta "/api/viajero"
 * @author jd.torres11
 */
@Path ("timelines")
@Produces("application/json")
public class TimelineResource {

 //incluir dependencia desde el pomp
    @Inject
    TimelineLogicMock timelineLogic;

    	/**
	 * Obtiene el listado de viajeros.
	 * @return lista de viajeros
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
    public List<TimelineDTO> getTimelines() throws PrimidLogicException {
        return timelineLogic.getTimelines();
    }

    /**
     * Obtiene un viajero
     * @param id identificador dl viajero
     * @return viajero encontrada
     * @throws PrimidLogicException cuando el viajero no existe
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

