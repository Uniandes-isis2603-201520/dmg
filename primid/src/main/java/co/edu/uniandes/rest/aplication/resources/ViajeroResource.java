/*
 *ViajeroResource.java
 * Clase que representa el viajero "/viajero"
 * Implementa varios métodos para manipular los viajeros
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.resources;


import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.ViajeroDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.mocks.ViajeroLogicMock;
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

@Produces("application/json")
public class ViajeroResource {

 //incluir dependencia desde el pomp
    @Inject
    ViajeroLogicMock viajeroLogic;

    	/**
	 * Obtiene el listado de viajeros.
	 * @return lista de viajeros
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
     @GET
    public List<ViajeroDTO> getViajeros() throws PrimidLogicException {
        return viajeroLogic.getViajeros();
    }

    /**
     * Obtiene un viajero
     * @param id identificador dl viajero
     * @return viajero encontrada
     * @throws PrimidLogicException cuando el viajero no existe
     */
         @GET
         @Path("viajeros/{id: \\d+}")
    public ViajeroDTO getViajero(@PathParam("id") Long id) throws PrimidLogicException   {
        return viajeroLogic.getViajeroPorId(id);
    }

     /**
     * Agrega un viajero
     * @param viajero viajero a agregar
     * @return datos del viajero a agregar
     * @throws PrimidLogicException cuando ya existe un viajero con el id suministrado
     */
         @POST
    public ViajeroDTO createViajeros(ViajeroDTO viajero) throws PrimidLogicException  {
        return viajeroLogic.createViajero(viajero);
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
    public ViajeroDTO updateViajero(@PathParam("id") Long id, ViajeroDTO viajero) throws PrimidLogicException {
        return viajeroLogic.updateViajero(id, viajero);
    }

    /**
     * Elimina los datos de un viajero
     * @param id identificador del viajero a eliminar
     * @throws PrimidLogicException cuando no existe un viajero con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteViajero(@PathParam("id") Long id) throws PrimidLogicException  {
        viajeroLogic.deleteViajero(id);
    }

}
