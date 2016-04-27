/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;

import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jd.torres11
 */
public class PlanCiudadPersistence {

    private static final Logger logger = Logger.getLogger(PlanCiudadPersistence.class.getName());

    @PersistenceContext(unitName = "primidPU")
    protected EntityManager em;

    public PlanCiudadEntity create(PlanCiudadEntity entity) {
        logger.info("Creando un plan ciudad nuevo");
        em.persist(entity);
        logger.info("plan ciudad creado");
        return entity;
    }

    public PlanCiudadEntity update(PlanCiudadEntity entity) {
        logger.log(Level.INFO, "Actualizando plan ciudad con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando plan ciudad con id={0}", id);
        PlanCiudadEntity entity = em.find(PlanCiudadEntity.class, id);
        em.remove(entity);
    }

    public PlanCiudadEntity find(Long id) {
        logger.log(Level.INFO, "Consultando plan ciudad con id={0}", id);
        return em.find(PlanCiudadEntity.class, id);
    }

    public List<PlanCiudadEntity> findAll() {
        logger.info("Consultando todos los plan ciudad");
        Query q = em.createQuery("select u from PlanCiudadEntity u");
        return q.getResultList();
    }
}
