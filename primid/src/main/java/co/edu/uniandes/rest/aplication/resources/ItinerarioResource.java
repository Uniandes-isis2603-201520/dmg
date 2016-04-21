/*
 *ItinerarioResource.java
 * Clase que representa el itinerario "/itinerario"
 * Implementa varios m茅todos para manipular los itinerarios
 */
package co.edu.uniandes.rest.aplication.resources;


//import co.edu.uniandes.rest.cities.dtos.ItinerarioDTO;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IItinerarioLogic;
import co.edu.uniandes.csw.primid.logic.ejbs.ItinerarioLogic;
import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.rest.aplication.converters.ItinerarioConverter;
import co.edu.uniandes.rest.aplication.dtos.ItinerarioDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.rest.aplication.mocks.ItinerarioLogicMock;


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
 * Note que la aplicaci贸n (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "itinerarios".
 * Al ejecutar la aplicaci贸n, el recurso ser谩 accesibe a trav茅s de la
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
    private IItinerarioLogic itinerarioLogic;

    //ViajeroResource viajeroResource;

    	/**
	 * Obtiene el listado de itinerarios.
	 * @return lista de itinerarios
	 * @throws PrimidLogicException excepci贸n retornada por la l贸gica
	 */
     @GET
     //@Path("/itinerarios")
    public List<ItinerarioDTO> getItinerarios(@PathParam("id_Viajero") Long idViajero) throws PrimidLogicException {
        logger.info("Se ejecuta m閠odo getItinerarios");
        //TODO
        List<ItinerarioEntity> itinerarios = itinerarioLogic.getItinerarios(idViajero);
        return ItinerarioConverter.listEntity2DTO(itinerarios);
    }

    /**
     * Obtiene un itinerario
     * @param id identificador dl itinerario
     * @return itinerario encontrada
     * @throws PrimidLogicException cuando el itinerario no existe
     */
    //TODO revisar BussinessLogicException
         @GET
         @Path("id: \\d+")
    public ItinerarioDTO getItinerario(@PathParam("id") Long id) throws PrimidLogicException, BusinessLogicException
    {
        logger.log(Level.INFO, "Se ejecuta m閠odo getItinerario con id={0}", id);
        ItinerarioEntity  i=itinerarioLogic.getItinerario(id);
        return ItinerarioConverter.basicEntity2DTO(i);


    }

     /**
     * Agrega un itinerario
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws PrimidLogicException cuando ya existe un itinerario con el id suministrado
     */
         @POST
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerarioDTO) throws PrimidLogicException
    {
        logger.info("Se ejecuta m閠odo createItinerario");
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(itinerarioDTO);
        ItinerarioEntity nuevo ;
        try
        {
            nuevo = itinerarioLogic.createItinerario(entity);
        }
        catch(Exception e)
        {
            logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
            throw new WebApplicationException(e.getLocalizedMessage(), e, Response.Status.BAD_REQUEST);
        }
        return ItinerarioConverter.fullEntity2DTO(nuevo);
        //try {
        //    newEntity = ItinerarioLogic.createItinerario(entity);
        //} catch (BusinessLogicException ex) {
           // logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
            //throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.BAD_REQUEST);
        //}
        //return BookConverter.fullEntity2DTO(newEntity);
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
    public ItinerarioDTO updateItinerario(@PathParam("id") Long id, ItinerarioDTO itinerario) throws PrimidLogicException, BusinessLogicException {
         logger.log(Level.INFO, "Se ejecuta m閠odo updateItinerario con id={0}", id);
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(itinerario);
        entity.setId(id);
        //ItinerarioEntity oldEntity = itinerarioLogic.getItinerario(id);

        try {
            ItinerarioEntity savedBook = itinerarioLogic.updateItinerario(entity);
            return ItinerarioConverter.fullEntity2DTO(savedBook);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.BAD_REQUEST);
        }

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
