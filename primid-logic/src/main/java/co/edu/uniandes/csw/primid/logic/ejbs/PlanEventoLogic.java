/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IPlanEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.PlanEventoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.gonzalez22
 */
@Stateless
public class PlanEventoLogic implements IPlanEventoLogic {


     private static final Logger logger = Logger.getLogger(PlanEventoLogic.class.getName());

    @Inject
    private PlanEventoPersistence persistence;

   
    
  

  
    public PlanEventoEntity getPlanEvento(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar planEvento con id={0}", id);
        PlanEventoEntity plan = persistence.find(id);
        if (plan == null) {
            logger.log(Level.SEVERE, "El planEvento con el id {0} no existe", id);
            throw new IllegalArgumentException("El autor solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar planEvento con id={0}", id);
        return plan;
    }

    
    public PlanEventoEntity createPlanEvento(PlanEventoEntity entity) {
        logger.info("Inicia proceso de creación de planEvento");
        persistence.create(entity);
        logger.info("Termina proceso de creación de planEvento");
        return entity;
    }

   
    public PlanEventoEntity updatePlanEvento(PlanEventoEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar planEvento con id={0}", entity.getId());
        PlanEventoEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar planEvento con id={0}", entity.getId());
        return newEntity;
    }

   
    public void deletePlanEvento(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar planEvento con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar planEvento con id={0}", id);
    }

  

 

   
    




}
