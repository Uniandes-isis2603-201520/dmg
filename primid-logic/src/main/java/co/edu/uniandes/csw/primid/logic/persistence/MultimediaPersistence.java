package co.edu.uniandes.csw.primid.logic.persistence;


//import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
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

    private static final Logger logger = Logger.getLogger(MultimediaPersistence.class.getName());

    @PersistenceContext(unitName = "BookStorePU")
    protected EntityManager em;

    public MultimediaEntity find(Long id) {
        logger.log(Level.INFO, "Consultando archivo multimedia con id={0}", id);
       return em.find(MultimediaEntity.class, id);
    }

    public List<MultimediaEntity> findAll() {
        logger.info("Consultando todos los archivos multimedia");
        Query q = em.createQuery("select u from MultimediaEntity u");
        return q.getResultList();
    }
}
