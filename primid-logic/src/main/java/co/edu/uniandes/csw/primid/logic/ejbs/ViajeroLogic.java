package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IViajeroLogic;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.csw.primid.logic.persistence.ViajeroPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ViajeroLogic implements IViajeroLogic{

    private static final Logger logger = Logger.getLogger(ViajeroLogic.class.getName());

    @Inject
    private ViajeroPersistence persistence;

    @Override
    public List<ViajeroEntity> getViajeros() {
        logger.info("Inicia proceso de consultar todos los viajeros");
        List<ViajeroEntity> viajeros = persistence.findAll();
        logger.info("Termina proceso de consultar todos los autores");
        return viajeros;
    }

    @Override
    public ViajeroEntity getViajero(Long id) throws BusinessLogicException {
      logger.log(Level.INFO, "Inicia proceso de consultar Viajero con id={0}", id);
        ViajeroEntity viajero = persistence.find(id);
        if (viajero == null) {
            logger.log(Level.SEVERE, "El viajero con el id {0} no existe", id);
            throw new BusinessLogicException("El viajero solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar viajero con id={0}", id);
        return viajero;
    }

    @Override
    public ViajeroEntity createViajero(ViajeroEntity entity) {
        logger.info("Inicia proceso de creación de viajero");
        persistence.create(entity);
        logger.info("Termina proceso de creación de viajero");
        return entity;
    }


    @Override
    public ViajeroEntity updateViajero(ViajeroEntity entity) {
       logger.log(Level.INFO, "Inicia proceso de actualizar viajero con id={0}", entity.getId());
        ViajeroEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar viajerp con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteViajero(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar viajero con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar viajero con id={0}", id);
    }


}
