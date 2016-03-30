    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.PlanEventoDTO;
import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.rest.aplication.mocks.CiudadLogicMock;

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
@Path("viajeros/{id_Viajero:\\d+}/itinerarios/{id_Itinerario:\\d+}/plan/{id_planC:\\d+}")
@Produces("application/json")
public class PlanEventoResource {

    @Inject
    CiudadLogicMock ciudadLogic;

    @GET
    public List<PlanEventoDTO> getPlanEventos() throws PrimidLogicException{
        return null;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("planE/{id_Plan: \\d+}")
    public PlanEventoDTO getPlanEventoPorId(@PathParam("id_Plan") Long id) throws PrimidLogicException {
        return null;
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public PlanEventoDTO createPlanEvento(PlanEventoDTO ciudad) throws PrimidLogicException {
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
    @Path("planE/{id_PlanUpdate: \\d+}")
    public PlanEventoDTO updatePlanEvento(@PathParam("id_PlanUpdate") Long id, PlanEventoDTO ciudad) throws PrimidLogicException {
        return null;
    }

    /**
     * Elimina los datos de una ciudad
     * @param id_PlanDelete identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("planE/{id_PlanDelete: \\d+}")
    public void deletePlanEvento(@PathParam("id_PlanDelete") Long id) throws PrimidLogicException {

    }

}
