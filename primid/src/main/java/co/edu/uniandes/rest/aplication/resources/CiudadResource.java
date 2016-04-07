    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.rest.aplication.dtos.CiudadDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.csw.primid.logic.api.ICiudadLogic;
import co.edu.uniandes.rest.aplication.converters.CiudadConverter;
import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;

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

/**
 *
 * @author andresvera
 */
@Path("ciudades")
@Produces("application/json")
public class CiudadResource {

    private static final Logger logger = Logger.getLogger(CiudadResource.class.getName());

    @Inject
    private ICiudadLogic ciudadLogic;

    @GET
    public List<CiudadDTO> getCiudades() {
        return CiudadConverter.listEntity2DTO(ciudadLogic.getCiudades());
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getCiudad(@PathParam("id") Long id) {
        return CiudadConverter.fullEntity2DTO(ciudadLogic.getCiudad(id));
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public CiudadDTO createCiudad(CiudadDTO dto) {
        CiudadEntity entity = CiudadConverter.fullDTO2Entity(dto);
        return CiudadConverter.fullEntity2DTO(ciudadLogic.createCiudad(entity));
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad(@PathParam("id") Long id, CiudadDTO dto) {
        CiudadEntity entity = CiudadConverter.fullDTO2Entity(dto);
        entity.setId(id);
        CiudadEntity oldEntity = ciudadLogic.getCiudad(id);
        //entity.setBooks(oldEntity.getBooks());
        return CiudadConverter.fullEntity2DTO(ciudadLogic.updateCiudad(entity));
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCiudad(@PathParam("id") Long id) {
        ciudadLogic.deleteCiudad(id);
    }

}