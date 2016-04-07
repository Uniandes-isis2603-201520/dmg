/*
 *ItinerarioResource.java
 * Clase que representa el itinerario "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 */
package co.edu.uniandes.rest.aplication.resources;


//import co.edu.uniandes.rest.cities.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;

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

/*
 * Clase que implementa el recurso REST correspondiente a "itinerarios".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "itinerarios".
 * Al ejecutar la aplicación, el recurso será accesibe a través de la
 * ruta "/api/itinerario"
 * @author la.mesa10
 */
@Path ("viajeros/{id_Viajero:\\d+}/itinerarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItinerarioResource {

    private static final Logger logger = Logger.getLogger(ItinerarioResource.class.getName());
 //incluir dependencia desde el pomp
    //Lo del mock ya no sino IauthorLogic   Autor
    @Inject
    private ItinerarioLogic itinerarioLogic;

    //ViajeroResource viajeroResource;

    	/**
	 * Obtiene el listado de itinerarios.
	 * @return lista de itinerarios
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
     //@Path("/itinerarios")
    public List<ItinerarioDTO> getItinerarios(@PathParam("id_Viajero") Long idViajero) throws PrimidLogicException {
        logger.info("Se ejecuta método getItinerarios");
        List<ItinerarioEntity> itinerarios = itinerarioLogic.getItinerarios();
        return ItinerariConverter.getItinerarios(idViajero);
    }

    /**
     * Obtiene un itinerario
     * @param id identificador dl itinerario
     * @return itinerario encontrada
     * @throws PrimidLogicException cuando el itinerario no existe
     */
         @GET
         @Path("id: \\d+")
    public ItinerarioDTO getItinerario(@PathParam("id") Long id) throws PrimidLogicException   {

        return itinerarioLogic.getItinerarioPorId(id);
    }

     /**
     * Agrega un itinerario
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws PrimidLogicException cuando ya existe un itinerario con el id suministrado
     */
         @POST
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerario) throws PrimidLogicException  {
        return itinerarioLogic.createItinerario(itinerario);
    }


        /**
     * Actualiza los datos de un itinerario
     * @param id identificador del itinerario a modificar
     * @param itinerario itinerario a modificar
     * @return datos del itinerario modificada
     * @throws PrimidLogicException cuando no existe un itinerario con el id suministrado
     */
         @PUT
         @Path("/{id: \\d+}")
    public ItinerarioDTO updateItinerario(@PathParam("id") Long id, ItinerarioDTO itinerario) throws PrimidLogicException {
        return itinerarioLogic.updateItinerario(id, itinerario);
    }

    /**
     * Elimina los datos de un itinerario
     * @param id identificador del itinerario a eliminar
     * @throws PrimidLogicException cuando no existe un itinerario con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteItinerario(@PathParam("id") Long id) throws PrimidLogicException  {
        itinerarioLogic.deleteItinerario(id);
    }

}
