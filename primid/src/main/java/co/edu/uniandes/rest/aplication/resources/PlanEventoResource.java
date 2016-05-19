/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.resources;

import co.edu.uniandes.csw.primid.logic.api.IPlanEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.rest.aplication.converters.CiudadConverter;
import co.edu.uniandes.rest.aplication.converters.PlanEventoConverter;
import co.edu.uniandes.rest.aplication.converters.ViajeroConverter;
import co.edu.uniandes.rest.aplication.dtos.PlanEventoDTO;
import co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;

import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *viajeros/{id_Viajero: \\d+}/itinerarios/{id_Itinerario: \\d+}/planCiudades/{id_PlanCiudad: \\d+}/planEventos
 * @author s.gonzalez22
 */
@Path("planEventos")
@Produces("application/json")
public class PlanEventoResource {

     private static final Logger logger = Logger.getLogger(PlanEventoResource.class.getName());


    @Inject
    private IPlanEventoLogic planEventoLogic;

    @GET
    public List<PlanEventoDTO> getPlanEventos() throws PrimidLogicException {
         logger.info("Se ejecuta metodo getCiudades");
        return PlanEventoConverter.listEntity2DTO(planEventoLogic.getPlanEventos());
     }

    /**
     * Obtiene una ciudad
     *
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("{id_Plan: \\d+}")
    public PlanEventoDTO getPlanEventoPorId(@PathParam("id_Plan") Long id) throws PrimidLogicException {
        return PlanEventoConverter.fullEntity2DTO(planEventoLogic.getPlanEvento(id));
    }

    /**
     * Agrega una ciudad
     *
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public PlanEventoDTO createPlanEvento(PlanEventoDTO ciudad) throws PrimidLogicException {
        PlanEventoEntity entity = PlanEventoConverter.fullDTO2Entity(ciudad);
        return PlanEventoConverter.fullEntity2DTO(planEventoLogic.createPlanEvento(entity));
    }

    /**
     * Actualiza los datos de una ciudad
     *
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public PlanEventoDTO updatePlanEvento(@PathParam("id") Long id, PlanEventoDTO dto) throws PrimidLogicException {
        PlanEventoEntity entity = PlanEventoConverter.fullDTO2Entity(dto);
        entity.setId(id);
        PlanEventoEntity oldEntity = planEventoLogic.getPlanEvento(id);
        PlanEventoEntity savedPlan = planEventoLogic.updatePlanEvento(entity);
        return PlanEventoConverter.fullEntity2DTO(savedPlan);

    }

    /**
     * Elimina los datos de una ciudad
     *
     * @param id_PlanDelete identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePlanEvento(@PathParam("id") Long id) throws PrimidLogicException {

        planEventoLogic.deletePlanEvento(id);

    }

}
