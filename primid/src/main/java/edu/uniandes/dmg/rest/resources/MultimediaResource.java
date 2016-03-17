/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;


import edu.uniandes.dmg.rest.dtos.MultimediaDTO;
import edu.uniandes.dmg.rest.exceptions.PrimidLogicException;
import edu.uniandes.dmg.rest.mocks.MultimediaLogicMock;
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
 *Clase que implementa el recurso REST correspondiente a "multimedia".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "multimedia".
 * Al ejecutar la aplicación, el recurso será accesibe a través de la
 * ruta "/api/multimedia"
 * @author fa.lopez10
 */
@Path("multimedia")
@Produces("application/json")
public class MultimediaResource {


    @Inject
    MultimediaLogicMock multimediaLogic;

    /**
	 * Obtiene el listado de archivos multimedia.
	 * @return lista de archivos multimedia
	 * @throws PrimidLogicException excepción retornada por la lógica
	 */
    @GET
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
        return multimediaLogic.getArchivoMultimedia(id);
    }

        /**
     * Agrega un archivo multimedia
     * @param multimedia archivo multimedia a agregar
     * @return datos del archivo multimedia a agregar
     * @throws PrimidLogicException cuando ya existe un archivo multimedia con el id suministrado
     */
         @POST
    public MultimediaDTO createArchivoMultimedia(MultimediaDTO multimedia) throws PrimidLogicException  {
        return multimediaLogic.createArchivoMultimedia(multimedia);
    }


        /**
     * Actualiza los datos de un viajero
     * @param id identificador del archivo multimedia a modificar
     * @param multimedia archivo multimedia a modificar
     * @return datos del archivo multimedia modificada
     * @throws PrimidLogicException cuando no existe un archivo multimedia con el id suministrado
     */
         @PUT
         @Path("{id: \\d+}")
    public MultimediaDTO updateArchivoMultimedia(@PathParam("id") Long id, MultimediaDTO multimedia) throws PrimidLogicException {
        return multimediaLogic.updateArchivoMultimedia(id, multimedia);
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
