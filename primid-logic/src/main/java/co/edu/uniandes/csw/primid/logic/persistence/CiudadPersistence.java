package co.edu.uniandes.csw.primid.logic.persistence;


import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CiudadPersistence {

    private static final Logger logger = Logger.getLogger(CiudadPersistence.class.getName());

    @PersistenceContext(unitName = "primidPU")
    protected EntityManager em;

    public CiudadEntity find(Long id) {
        logger.log(Level.INFO, "Consultando ciudad con id={0}", id);
        return em.find(CiudadEntity.class, id);
    }

    public List<CiudadEntity> findAll() {
        logger.info("Consultando todos las ciudades");
        Query q = em.createQuery("select u from CiudadEntity u");
        return q.getResultList();
    }

    public CiudadEntity create(CiudadEntity entity) {
        logger.info("Creando una ciudad");
        em.persist(entity);
        logger.info("ciudad creada");
        return entity;
    }

    public CiudadEntity update(CiudadEntity entity) {
        logger.log(Level.INFO, "Actualizando ciudad con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando ciudad con id={0}", id);
        CiudadEntity entity = em.find(CiudadEntity.class, id);
        em.remove(entity);
    }
}