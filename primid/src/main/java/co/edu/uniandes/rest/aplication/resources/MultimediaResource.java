/*
 *MultimediaResource.java
 * Clase que representa el archivo multimedia "/multimedia"
 * Implementa varios métodos para manipular los viajeros
 */
package co.edu.uniandes.rest.aplication.resources;


import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.MultimediaDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.rest.aplication.mocks.MultimediaLogicMock;
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
 * Clase que implementa el recurso REST correspondiente a "multimedia".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "multimedia".
 * Al ejecutar la aplicación, el recurso será accesibe a través de la
 * ruta "/api/multimedia"
 * @author fa.lopez10
 */
@Path ("viajeros/{id}/itinerario/{id}/ciudades/{id}/eventos/{id}/multimedia")
@Produces("application/json")
public class MultimediaResource {

 //incluir dependencia desde el pom
    @Inject
    MultimediaLogicMock multimediaLogic;

    	/**
	 * Obtiene el listado de archivos Multimedia.
	 * @return lista de archivos Multimedia
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
    @GET
    @Path("/multimedia")
    public List<MultimediaDTO> getMultimedia() throws PrimidLogicException {
        return multimediaLogic.getMultimedia();
    }

    /**
     * Obtiene un archivo multimedia
     * @param id identificador dl archivo multimedia
     * @return archivo multimedia encontrada
     * @throws PrimidLogicException cuando el archivo multimedia no existe
     */
    @GET
    @Path("{id: \\d+}")
    public MultimediaDTO getArchivoMultimedia(@PathParam("id") Long id) throws PrimidLogicException   {
        return multimediaLogic.getArchivoMultimediaPorId(id);
    }

    /**
     * Agrega un archivo multimedia
     * @param mult archivo multimedia a agregar
     * @return datos del archivo multimedia a agregar
     * @throws PrimidLogicException cuando ya existe un archivo multimedia con el id suministrado
     */
         @POST
    public MultimediaDTO createArchivoMultimedia(MultimediaDTO mult) throws PrimidLogicException  {
        return multimediaLogic.createArchivoMultimedia(mult);
    }


    /**
     * Actualiza los datos de un archivo multimedia
     * @param id identificador del archivo multimedia a modificar
     * @param mult archivo multimedia a modificar
     * @return datos del archivo multimedia modificada
     * @throws PrimidLogicException cuando no existe un archivo multimedia con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public MultimediaDTO updateArchivoMultimedia(@PathParam("id") Long id, MultimediaDTO mult) throws PrimidLogicException {
        return multimediaLogic.updateArchivoMultimedia(id, mult);
    }

    /**
     * Elimina los datos de un archivo multimedia
     * @param id identificador del archivo multimedia a eliminar
     * @throws PrimidLogicException cuando no existe un archivo multimedia con el id suministrado
     */

         @DELETE
         @Path("{id: \\d+}")
    public void deleteArchivoMultimedia(@PathParam("id") Long id) throws PrimidLogicException  {
        multimediaLogic.deleteArchivoMultimedia(id);
    }

}
