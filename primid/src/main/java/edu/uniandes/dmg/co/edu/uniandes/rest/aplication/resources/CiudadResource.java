/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.cities.resources;

import edu.uniandes.dmg.co.edu.uniandes.rest.cities.dtos.CiudadDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import edu.uniandes.dmg.co.edu.uniandes.rest.cities.mocks.CiudadLogicMock;

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
 *
 * @author andresvera
 */
@Path("ciudades")
@Produces("application/json")
public class CiudadResource {

    @Inject
    CiudadLogicMock ciudadLogic;

    @GET
    public List<CiudadDTO> getCiudades() throws PrimidLogicException{
        return ciudadLogic.getCities();
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
