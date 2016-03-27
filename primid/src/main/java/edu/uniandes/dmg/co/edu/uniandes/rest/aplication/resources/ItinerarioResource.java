/*
 *ItinerarioResource.java
 * Clase que representa el itinerario "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.resources;


//import co.edu.uniandes.rest.cities.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.mocks.ItinerarioLogicMock;

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
 * Clase que implementa el recurso REST correspondiente a "itinerarios".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "itinerarios".
 * Al ejecutar la aplicación, el recurso será accesibe a través de la
 * ruta "/api/itinerario"
 * @author la.mesa10
 */
@Path ("viajeross")
@Produces("application/json")
public class ItinerarioResource {

 //incluir dependencia desde el pomp
    @Inject
    ItinerarioLogicMock itinerarioLogic;
    ViajeroResource viajeroResource;

    	/**
	 * Obtiene el listado de itinerarios.
	 * @return lista de itinerarios
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
     @Path("{id_Viajero:\\d+}/itinerarios")
    public List<ItinerarioDTO> getItinerarios(@PathParam("id_Viajero") Long idViajero) throws PrimidLogicException {

        return itinerarioLogic.getItinerarios(idViajero);
    }

    /**
     * Obtiene un itinerario
     * @param id identificador dl itinerario
     * @return itinerario encontrada
     * @throws PrimidLogicException cuando el itinerario no existe
     */
         @GET
         @Path("id: \\d")
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
    public ItinerarioDTO createItinerarios(ItinerarioDTO itinerario) throws PrimidLogicException  {
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
         @Path("{id: \\d+}")
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
