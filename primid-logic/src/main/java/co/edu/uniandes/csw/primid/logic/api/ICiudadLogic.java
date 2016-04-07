package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.CiudadEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

public interface ICiudadLogic {

    public List<CiudadEntity> getCiudades();

    public CiudadEntity getCiudad(Long id) ;

    public CiudadEntity createCiudad(CiudadEntity entity);

    public CiudadEntity updateCiudad(CiudadEntity entity);

    public void deleteCiudad(Long id);
    
}