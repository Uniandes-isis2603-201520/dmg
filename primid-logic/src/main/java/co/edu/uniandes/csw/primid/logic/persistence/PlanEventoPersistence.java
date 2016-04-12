/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;


import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author s.gonzalez22
 */
@Stateless
public class PlanEventoPersistence {

    private static final Logger logger = Logger.getLogger(PlanEventoPersistence.class.getName());

    @PersistenceContext(unitName = "primidPU")
    protected EntityManager em;

    public PlanEventoEntity create(PlanEventoEntity entity) {
        logger.info("Creando un autor nuevo");
        em.persist(entity);
        logger.info("Autor creado");
        return entity;
    }

    public PlanEventoEntity update(PlanEventoEntity entity) {
        logger.log(Level.INFO, "Actualizando autor con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando autor con id={0}", id);
        PlanEventoEntity entity = em.find(PlanEventoEntity.class, id);
        em.remove(entity);
    }

    public PlanEventoEntity find(Long id) {
        logger.log(Level.INFO, "Consultando autor con id={0}", id);
        return em.find(PlanEventoEntity.class, id);
    }

    public List<PlanEventoEntity> findAll() {
        logger.info("Consultando todos los autores");
        Query q = em.createQuery("select u from AuthorEntity u");
        return q.getResultList();
    }

}
