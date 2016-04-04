/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.csw.primid.logic.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author la.mesa10
 */
public class ItinerarioLogic
{
    private static final Logger logger = Logger.getLogger(ItinerarioLogic.class.getName());

    @Inject
    private ItinerarioPersistence persistence;

    public List<ItinerarioEntity> getItinerarios() {
        logger.info("Inicia proceso de consultar todos los itinerarios");
        List<ItinerarioEntity> itinerarios = persistence.findAll();
        logger.info("Termina proceso de consultar todos los libros");
        return itinerarios;
    }

     public ItinerarioEntity getItinerario(Long id) throws BusinessLogicException {
        logger.log(Level.INFO, "Inicia proceso de consultar editorial con id={0}", id);
        ItinerarioEntity itinerario = persistence.find(id);
        if (itinerario == null) {
            logger.log(Level.SEVERE, "El itinerario con el id {0} no existe", id);
            throw new BusinessLogicException("El itinierario solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar itinerario con id={0}", id);
        return itinerario;
    }

    public ItinerarioEntity createItinerario(ItinerarioEntity entity) {
        logger.info("Inicia proceso de creación de itinerario");
        persistence.create(entity);
        logger.info("Termina proceso de creación de itinerario");
        return entity;
    }


    public ItinerarioEntity updateItinerario(ItinerarioEntity entity)
    {
        logger.log(Level.INFO, "Inicia proceso de actualizar itinerario con id={0}", entity.getId());
        ItinerarioEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar itinerario con id={0}", entity.getId());
        return newEntity;
    }


    public void deleteItinerario(Long id)
    {
        logger.log(Level.INFO, "Inicia proceso de borrar itinerario con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar itinerario con id={0}", id);
    }


    //public ItinerarioEntity addItinerario(Long bookId, Long itinerarioId) {
      //  EditorialEntity editorialEntity = persistence.find(editorialId);
        //BookEntity bookEntity = bookPersistence.find(bookId);
        //bookEntity.setEditorial(editorialEntity);
        //return bookEntity;
    //}


    //public void removeBook(Long bookId, Long editorialId) {
      //  EditorialEntity editorialEntity = persistence.find(editorialId);
        //BookEntity book = bookPersistence.find(bookId);
        //book.setEditorial(null);
        //editorialEntity.getBooks().remove(book);
    //}

    //@Override
    //public List<BookEntity> replaceBooks(List<BookEntity> books, Long editorialId) {
      //  EditorialEntity editorial = persistence.find(editorialId);
        //List<BookEntity> bookList = bookPersistence.findAll();
        //for (BookEntity book : bookList) {
          //  if (books.contains(book)) {
            //    book.setEditorial(editorial);
            //} else if (book.getEditorial() != null && book.getEditorial().equals(editorial)) {
              //  book.setEditorial(null);
            //}
       // }
        //return books;
    //}

    //@Override
    //public List<BookEntity> getBooks(Long editorialId) {
      //  return persistence.find(editorialId).getBooks();
    //}

    //@Override
    //public BookEntity getBook(Long editorialId, Long bookId) {
      //  List<BookEntity> books = persistence.find(editorialId).getBooks();
        //BookEntity book = new BookEntity();
        //book.setId(bookId);
        //int index = books.indexOf(book);
        //if (index >= 0) {
          //  return books.get(index);
        //}
        //return null;
    //}
}
