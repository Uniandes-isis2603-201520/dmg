package co.edu.uniandes.csw.primid.logic.persistence;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MultimediaPersistence {

    private static final Logger logger = Logger.getLogger(BookPersistence.class.getName());

    @PersistenceContext(unitName = "BookStorePU")
    protected EntityManager em;

    public BookEntity find(Long id) {
        logger.log(Level.INFO, "Consultando libro con id={0}", id);
        return em.find(BookEntity.class, id);
    }

    public List<MultimediaEntity> findAll() {
        logger.info("Consultando todos los archivos multimedia");
        Query q = em.createQuery("select u from MultimediaEntity u");
        return q.getResultList();
    }

    public MultimediaEntity create(MultimediaEntity entity) {
        logger.info("Creando un archivo multimedia nuevo");
        em.persist(entity);
        logger.info("archivo multimedia creado");
        return entity;
    }

    public BookEntity update(BookEntity entity) {
        logger.log(Level.INFO, "Actualizando libro con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        logger.log(Level.INFO, "Borrando libro con id={0}", id);
        BookEntity entity = em.find(BookEntity.class, id);
        em.remove(entity);
    }
}
