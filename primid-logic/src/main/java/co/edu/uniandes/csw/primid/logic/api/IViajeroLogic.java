package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

public interface IViajeroLogic {

    public List<ViajeroEntity> getViajeros();

    public ViajeroEntity getViajero(Long id) throws BusinessLogicException;

    public ViajeroEntity createViajero(ViajeroEntity entity);

    public ViajeroEntity updateViajero(ViajeroEntity entity);

    public void deleteViajero(Long id);

}
