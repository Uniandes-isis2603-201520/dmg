/*
 *MultimediaResource.java
 * Clase que representa el archivo multimedia "/multimedia"
 * Implementa varios métodos para manipular los viajeros
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.api.IMultimediaLogic;
import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.rest.aplication.converters.MultimediaConverter;
import co.edu.uniandes.rest.aplication.dtos.MultimediaDTO;

import co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Note que la aplicacion (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "multimedia".
 * Al ejecutar la aplicacion, el recurso será accesibe a través de la
 * ruta "/api/multimedia"
 * @author fa.lopez10
 */
@Path("viajeros/{id_Viajero:\\d+}/itinerario/{id_Itinerario:\\d+}/ciudades/{id_Ciudad:\\d+}/eventos/{id_Evento:\\d+}/multimedia")
@Produces("application/json")
public class MultimediaResource {

    private static final Logger logger = Logger.getLogger(MultimediaResource.class.getName());
    @Inject
    IMultimediaLogic multimediaLogic;

    /**
     * Obtiene el listado de archivos Multimedia.
     *
     * @return lista de archivos Multimedia
     * @throws PrimidLogicException excepcion retornada por la logica
     */
    @GET
    @Path("/multimedia")
    public List<MultimediaDTO> getMultimedia() throws BusinessLogicException {
        return MultimediaConverter.listEntity2DTO(multimediaLogic.getMultimedia());
    }

    /**
     * Obtiene un archivo multimedia
     *
     * @param id identificador dl archivo multimedia
     * @return archivo multimedia encontrada
     * @throws PrimidLogicException cuando el archivo multimedia no existe
     */
    @GET
    @Path("{id: \\d+}")
    public MultimediaDTO getArchivoMultimedia(@PathParam("id") Long id) throws BusinessLogicException {
        MultimediaEntity entity;

        entity = multimediaLogic.getArchivoMultimedia(id);
        return MultimediaConverter.basicEntity2DTO(entity);

    }

    /**
     * Agrega un archivo multimedia
     *
     * @param mult archivo multimedia a agregar
     * @return datos del archivo multimedia a agregar
     * @throws PrimidLogicException cuando ya existe un archivo multimedia con
     * el id suministrado
     */
    @POST
    public MultimediaDTO createArchivoMultimedia(MultimediaDTO mult) throws PrimidLogicException {
        MultimediaEntity entity = MultimediaConverter.basicDTO2Entity(mult);
        MultimediaEntity newEntity;

        newEntity = multimediaLogic.createArchivoMultimedia(entity);

        return MultimediaConverter.basicEntity2DTO(newEntity);
    }

    /**
     * Actualiza los datos de un archivo multimedia
     *
     * @param id identificador del archivo multimedia a modificar
     * @param mult archivo multimedia a modificar
     * @return datos del archivo multimedia modificada
     * @throws PrimidLogicException cuando no existe un archivo multimedia con
     * el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public MultimediaDTO updateArchivoMultimedia(@PathParam("id") Long id, MultimediaDTO dto) throws BusinessLogicException {

        MultimediaEntity entity = MultimediaConverter.basicDTO2Entity(dto);
        entity.setId(id);

        MultimediaEntity oldEntity = multimediaLogic.getArchivoMultimedia(id);

        MultimediaEntity savedMultimedia = multimediaLogic.updateArchivoMultimedia(entity);
        return MultimediaConverter.basicEntity2DTO(savedMultimedia);

    }

    /**
     * Elimina los datos de un archivo multimedia
     *
     * @param id identificador del archivo multimedia a eliminar
     * @throws PrimidLogicException cuando no existe un archivo multimedia con
     * el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteArchivoMultimedia(@PathParam("id") Long id) throws PrimidLogicException {
        logger.log(Level.INFO, "Se ejecuta metodo deleteArchivoMultimedia con id={0}", id);
        multimediaLogic.deleteArchivoMultimedia(id);
    }

}
