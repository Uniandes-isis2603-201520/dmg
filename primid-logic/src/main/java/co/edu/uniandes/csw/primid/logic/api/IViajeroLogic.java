package co.edu.uniandes.csw.primid.logic.api;


import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import java.util.List;

public interface IViajeroLogic {

    public List<ViajeroEntity> getViajeros();

    public ViajeroEntity getViajero(Long id) throws BusinessLogicException;

    public ViajeroEntity createViajero(ViajeroEntity entity);

    public ViajeroEntity updateViajero(ViajeroEntity entity);

    public void deleteViajero(Long id);

    public ItinerarioEntity addBook(Long itinerarioId, Long authorId) throws BusinessLogicException;

    public void removeBook(Long itinerarioId, Long authorId);

    public List<ItinerarioEntity> replaceBooks(List<ItinerarioEntity> itinerarios, Long authorId) throws BusinessLogicException;

    public List<ItinerarioEntity> getBooks(Long authorId);

    public ItinerarioEntity getBook(Long authorId, Long itinerarioId);
}
