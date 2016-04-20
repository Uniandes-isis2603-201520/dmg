    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.api.IPlanCiudadLogic;
import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.rest.aplication.converters.PlanCiudadConverter;
import co.edu.uniandes.rest.aplication.dtos.PlanCiudadDTO;

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
    private IPlanCiudadLogic planCiudadLogic;

/**
	 * Obtiene el listado de plan ciudades.
	 * @return lista de plan ciudades
	 * @throws BusinessLogicException excepci�n retornada por la l�gica
	 */
    @Path("planCiudades")
    @GET
    public List<PlanCiudadDTO> getPlanCiudades() throws BusinessLogicException{
        return PlanCiudadConverter.listEntity2DTO(planCiudadLogic.getPlanCiudades());
    }

    /**
     * Obtiene una ciudad
     * @param id identificador del plan Ciudad
     * @return plan ciudad encontradao
     * @throws BusinessLogicException cuando el plan ciudad no existe
     */
    @GET
    @Path("planC/{id_Plan: \\d+}")
    public PlanCiudadDTO getPlanCiudadPorId(@PathParam("id_Plan") Long id) throws BusinessLogicException {
        return PlanCiudadConverter.fullEntity2DTO(planCiudadLogic.getPlanCiudad(id));
    }

    /**
     * Agrega un plan ciudad
     * @param planCiudad plan ciudad a agregar
     * @return datos del plan ciudad a agregar
     * @throws BusinessLogicException cuando ya existe un plan ciudad con el id suministrado
     */
    @POST
    public PlanCiudadDTO createPlanCiudad(PlanCiudadDTO planCiudad) throws BusinessLogicException {
      PlanCiudadEntity entity = PlanCiudadConverter.fullDTO2Entity(planCiudad);
        return PlanCiudadConverter.fullEntity2DTO(planCiudadLogic.createPlanCiudad(entity));
    }

    /**
     * Actualiza los datos de un plan ciudad
     * @param id identificador del plan ciudad a modificar
     * @param planCiudad plan ciudad a modificar
     * @return datos del plan ciudad modificada
     * @throws BusinessLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("planC/{id_PlanUpdate: \\d+}")
    public PlanCiudadDTO updatePlanCiudad(@PathParam("id_PlanUpdate") Long id, PlanCiudadDTO planCiudad) throws BusinessLogicException {
        return null;
    }

    /**
     * Elimina los datos del plan ciudad
     * @param id identificador del plan ciudad a eliminar
     * @throws BusinessLogicException cuando no existe un plan ciudad con el id suministrado
     */
    @DELETE
    @Path("planC/{id_PlanDelete: \\d+}")
    public void deletePlanCiudad(@PathParam("id_PlanDelete") Long id) throws BusinessLogicException {

         planCiudadLogic.deletePlanCiudad(id);
    }

}
