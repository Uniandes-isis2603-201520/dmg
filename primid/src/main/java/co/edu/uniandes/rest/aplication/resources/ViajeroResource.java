/*
 *ViajeroResource.java
 * Clase que representa el viajero "/viajero"
 * Implementa varios metodos para manipular los viajeros
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IViajeroLogic;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.rest.aplication.converters.ViajeroConverter;
import co.edu.uniandes.rest.aplication.dtos.ViajeroDTO;
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

/*
 * Clase que implementa el recurso REST correspondiente a "viajeros".
 *
 * Note que la aplicacion (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "viajeros".
 * Al ejecutar la aplicacion, el recurso sera accesibe a traves de la
 * ruta "/api/viajero"
 * @author jd.torres11
 */
@Path("viajeros")
@Produces("application/json")
public class ViajeroResource {

    //incluir dependencia desde el pomp
    @Inject
    private IViajeroLogic viajeroLogic;

    /**
     * Obtiene el listado de viajeros.
     *
     * @return lista de viajeros
     * @throws BusinessLogicException excepcion retornada por la logica
     */
    @GET
    public List<ViajeroDTO> getViajeros() throws BusinessLogicException {
        return ViajeroConverter.listEntity2DTO(viajeroLogic.getViajeros());
    }

    /**
     * Obtiene un viajero
     *
     * @param id identificador dl viajero
     * @return viajero encontrada
     * @throws BusinessLogicException cuando el viajero no existe
     */
    @GET
    @Path("{id: \\d+}")
    public ViajeroDTO getViajero(@PathParam("id") Long id) throws BusinessLogicException {
        return ViajeroConverter.fullEntity2DTO(viajeroLogic.getViajero(id));
    }

    /**
     * Agrega un viajero
     *
     * @param viajero viajero a agregar
     * @return datos del viajero a agregar
     * @throws BusinessLogicException cuando ya existe un viajero con el id
     * suministrado
     */
    @POST
    public ViajeroDTO createViajeros(ViajeroDTO viajero) throws BusinessLogicException {
        ViajeroEntity entity = ViajeroConverter.fullDTO2Entity(viajero);
        return ViajeroConverter.fullEntity2DTO(viajeroLogic.createViajero(entity));

    }

    /**
     * Actualiza los datos de un viajero
     *
     * @param id identificador del viajero a modificar
     * @param viajero viajero a modificar
     * @return datos del viajero modificada
     * @throws BusinessLogicException cuando no existe un viajero con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ViajeroDTO updateViajero(@PathParam("id") Long id, ViajeroDTO viajero) throws BusinessLogicException {

        return null;
    }

    /**
     * Elimina los datos de un viajero
     *
     * @param id identificador del viajero a eliminar
     * @throws PrimidLogicException cuando no existe un viajero con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteViajero(@PathParam("id") Long id) throws BusinessLogicException {
        viajeroLogic.deleteViajero(id);
    }

}
