/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IPlanCiudadLogic;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IPlanEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.PlanCiudadPersistence;
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
public class PlanCiudadLogic implements IPlanCiudadLogic {

    private static final Logger logger = Logger.getLogger(PlanCiudadLogic.class.getName());

    @Inject
    private PlanCiudadPersistence persistence;

    @Override
    public List<PlanCiudadEntity> getPlanCiudades() {
        logger.info("Inicia proceso de consultar todos los plan ciudades");
        List<PlanCiudadEntity> planCiudades = persistence.findAll();
        logger.info("Termina proceso de consultar todos los plan ciudades");
        return planCiudades;
    }

    @Override
    public PlanCiudadEntity getPlanCiudad(Long id) throws BusinessLogicException {
        logger.log(Level.INFO, "Inicia proceso de consultar el plan Ciudad con id={0}", id);
        PlanCiudadEntity planCiudad = persistence.find(id);
        if (planCiudad == null) {
            logger.log(Level.SEVERE, "El plan ciudad con el id {0} no existe", id);
            throw new BusinessLogicException("El plan ciudad solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar el plan ciudad con id={0}", id);
        return planCiudad;
    }

    @Override
    public PlanCiudadEntity createPlanCiudad(PlanCiudadEntity entity) {
        logger.info("Inicia proceso de creación del plan Ciudad");
        persistence.create(entity);
        logger.info("Termina proceso de creación de plan Ciudad");
        return entity;
    }

    @Override
    public PlanCiudadEntity updatePlanCiudad(PlanCiudadEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar plan ciudad con id={0}", entity.getId());
        PlanCiudadEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar plan ciudad con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deletePlanCiudad(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar plan Ciudad con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar plan Ciudad con id={0}", id);
    }

}
