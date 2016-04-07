package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;
import co.edu.uniandes.csw.primid.logic.persistence.CiudadPersistence;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CiudadLogic {

    private static final Logger logger = Logger.getLogger(CiudadLogic.class.getName());

    @Inject
    private CiudadPersistence persistence;

    public List<CiudadEntity> getCiudades() {
        logger.info("Inicia proceso de consultar todos las ciudades");
        List<CiudadEntity> ciudades = persistence.findAll();
        logger.info("Termina proceso de consultar todos las ciudades");
        return ciudades;
    }



}
