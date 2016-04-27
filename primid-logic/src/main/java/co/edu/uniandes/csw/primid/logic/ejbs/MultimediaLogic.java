package co.edu.uniandes.csw.primid.logic.ejbs;

//import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.api.IMultimediaLogic;
import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.persistence.MultimediaPersistence;
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
public class MultimediaLogic implements IMultimediaLogic {

    private static final Logger logger = Logger.getLogger(MultimediaLogic.class.getName());

    @Inject
    private MultimediaPersistence persistence;

    @Override
    public List<MultimediaEntity> getMultimedia() {
        logger.info("Inicia proceso de consultar todos los archivos multimedia");
        List<MultimediaEntity> archivosMultimedia = persistence.findAll();
        logger.info("Termina proceso de consultar todos los archivos multimedia");
        return archivosMultimedia;
    }

    @Override
    public MultimediaEntity getArchivoMultimedia(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar archivo Multimedia con id={0}", id);
        MultimediaEntity archivoMultimedia = persistence.find(id);
        if (archivoMultimedia == null) {
            logger.log(Level.SEVERE, "El archivo Multimedia con el id {0} no existe", id);
            throw new IllegalArgumentException("El archivo Multimedia solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar archivo Multimedia con id={0}", id);
        return archivoMultimedia;
    }

    @Override
    public MultimediaEntity createArchivoMultimedia(MultimediaEntity entity) {
        logger.info("Inicia proceso de creación de archivo multimedia");

        persistence.create(entity);
        logger.info("Termina proceso de creación de archivo multimedia");
        return entity;
    }

    @Override
    public MultimediaEntity updateArchivoMultimedia(MultimediaEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar archivo multimedia con id={0}", entity.getId());

        MultimediaEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar archivo multimedia con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteArchivoMultimedia(Long id) {
        logger.log(Level.INFO, "Inicia proceso de archivo multimedia con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar archivo multimedia con id={0}", id);
    }

}
