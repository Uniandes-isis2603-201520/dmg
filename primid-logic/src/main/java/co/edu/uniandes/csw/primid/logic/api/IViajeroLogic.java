package co.edu.uniandes.csw.primid.logic.api;


import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

public interface IViajeroLogic {

    public List<ViajeroEntity> getViajeros();

    public ViajeroEntity getViajero(Long id) throws BusinessLogicException;

    public ViajeroEntity createViajero(ViajeroEntity entity);

    public ViajeroEntity updateViajero(ViajeroEntity entity);

    public void deleteViajero(Long id);

    //public ItinerarioEntity addI(Long itinerarioId, Long authorId) throws BusinessLogicException;

    //public void removeItinerario(Long itinerarioId, Long authorId);

    //public List<ItinerarioEntity> replaceItinerarios(List<ItinerarioEntity> itinerarios, Long authorId) throws BusinessLogicException;

    //public List<ItinerarioEntity> getItinerarios(Long authorId);

    // public ItinerarioEntity getItinerario(Long authorId, Long itinerarioId);
}
