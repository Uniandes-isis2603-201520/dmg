package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;

import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

public interface IItinerarioLogic {

    public List<ItinerarioEntity> getItinerarios();

    public List<ItinerarioEntity> getItinerarios(Long idViajero);

    public ItinerarioEntity getItinerario(Long id) throws BusinessLogicException;

    public ItinerarioEntity createItinerario(ItinerarioEntity entity);

    public ItinerarioEntity updateItinerario(ItinerarioEntity entity);

    public void deleteItinerario(Long id);

}
