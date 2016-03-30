/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import java.util.List;
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
        logger.info("Inicia proceso de consultar todos los ");
        List<ItinerarioEntity> books = persistence.findAll();
        logger.info("Termina proceso de consultar todos los libros");
        return books;
    }
}
