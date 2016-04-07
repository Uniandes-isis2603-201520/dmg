    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import edu.uniandes.dmg.co.edu.uniandes.rest.cities.dtos.CiudadDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.csw.primid.logic.api.ICiudadLogic;

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
    public List<CiudadDTO> getCiudades() throws PrimidLogicException{
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
    public CiudadDTO getCity(@PathParam("id") Long id) throws PrimidLogicException {
        return ciudadLogic.getCity(id);
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public CiudadDTO createCity(CiudadDTO ciudad) throws PrimidLogicException {
        return ciudadLogic.createCity(ciudad);
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
    public CiudadDTO updateCity(@PathParam("id") Long id, CiudadDTO ciudad) throws PrimidLogicException {
        return ciudadLogic.updateCity(id, ciudad);
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) throws PrimidLogicException {
    	ciudadLogic.deleteCity(id);
    }

}
