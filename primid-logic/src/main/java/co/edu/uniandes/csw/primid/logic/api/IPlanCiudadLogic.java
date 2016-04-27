/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author s.gonzalez22
 */
public interface IPlanCiudadLogic {

    public List<PlanCiudadEntity> getPlanCiudades();

    public PlanCiudadEntity getPlanCiudad(Long id) throws BusinessLogicException;

    public PlanCiudadEntity createPlanCiudad(PlanCiudadEntity entity);

    public PlanCiudadEntity updatePlanCiudad(PlanCiudadEntity entity);

    public void deletePlanCiudad(Long id);
}
