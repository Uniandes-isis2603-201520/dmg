    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.co.edu.uniandes.rest.aplication.resources;

import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.PlanCiudadDTO;
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
@Path("viajeros/{id_Viajero:\\d+}/itinerarios/{id_Itinerario:\\d+}")
@Produces("application/json")
public class PlanCiudadResource {

    @Inject
    CiudadLogicMock ciudadLogic;

    @GET
    public List<PlanCiudadDTO> getPlanCiudades() throws PrimidLogicException{
        return null;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("planC/{id_Plan: \\d+}")
    public PlanCiudadDTO getPlanCiudadPorId(@PathParam("id_Plan") Long id) throws PrimidLogicException {
        return null;
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public PlanCiudadDTO createPlanCiudad(PlanCiudadDTO ciudad) throws PrimidLogicException {
        return null;
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("planC/{id_PlanUpdate: \\d+}")
    public PlanCiudadDTO updatePlanCiudad(@PathParam("id_PlanUpdate") Long id, PlanCiudadDTO ciudad) throws PrimidLogicException {
        return null;
    }

    /**
     * Elimina los datos de una ciudad
     * @param id_PlanDelete identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("planC/{id_PlanDelete: \\d+}")
    public void deletePlanCiudad(@PathParam("id_PlanDelete") Long id) throws PrimidLogicException {

    }

}
