package co.edu.uniandes.csw.primid.logic.ejbs;


//import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.persistence.MultimediaPersistence;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author fa.lopez10
 */
@Stateless
public class MultimediaLogic {

    private static final Logger logger = Logger.getLogger(MultimediaLogic.class.getName());

    @Inject
    private MultimediaPersistence persistence;



//    public List<MultimediaEntity> getArchivosMultimedia() {
//        logger.info("Inicia proceso de consultar todos los archivos multimedia");
//        List<MultimediaEntity> archivosMultimedia = persistence.findAll();
//        logger.info("Termina proceso de consultar todos los archivos multimedia");
//        return archivosMultimedia;
//    }
//


}
