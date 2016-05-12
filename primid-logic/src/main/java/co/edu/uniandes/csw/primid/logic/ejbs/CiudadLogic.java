package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;
import co.edu.uniandes.csw.primid.logic.persistence.CiudadPersistence;
import co.edu.uniandes.csw.primid.logic.api.ICiudadLogic;
import co.edu.uniandes.csw.primid.logic.api.IPlanCiudadLogic;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CiudadLogic implements ICiudadLogic {

    private static final Logger logger = Logger.getLogger(CiudadLogic.class.getName());

    @Inject
    private CiudadPersistence persistence;

    @Inject
    private IPlanCiudadLogic planCiudad;

    @Override
    public List<CiudadEntity> getCiudades() {
        logger.info("Inicia proceso de consultar todas las ciudades");
        List<CiudadEntity> ciudades = persistence.findAll();
        logger.info("Termina proceso de consultar todas las ciudades");
        return ciudades;
    }

    @Override
    public CiudadEntity getCiudad(Long id){
     logger.log(Level.INFO, "Inicia proceso de consultar ciudad con id={0}", id);
     CiudadEntity ciudad = persistence.find(id);
        logger.log(Level.INFO, "Termina proceso de consultar ciudad con id={0}", id);
        return ciudad;
    }

    @Override
    public CiudadEntity createCiudad(CiudadEntity entity) {
        logger.info("Inicia proceso de creación de ciudad");
        persistence.create(entity);
        logger.info("Termina proceso de creación de ciudad");
        return entity;
    }

    @Override
    public CiudadEntity updateCiudad(CiudadEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar ciudad con id={0}", entity.getId());
        CiudadEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar ciudad con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteCiudad(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar ciudad con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar ciudad con id={0}", id);
    }

}
