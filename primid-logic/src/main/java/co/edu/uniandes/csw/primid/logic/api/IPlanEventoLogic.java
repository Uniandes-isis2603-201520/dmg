/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author s.gonzalez22
 */
public interface IPlanEventoLogic {

     public List<PlanEventoEntity> getPlanEventos();

    public PlanEventoEntity getPlanEvento(Long id);

    public PlanEventoEntity createPlanEvento(PlanEventoEntity entity);

    public PlanEventoEntity updatePlanEvento(PlanEventoEntity entity);

    public void deletePlanEvento(Long id);

}
