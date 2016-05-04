/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;


import co.edu.uniandes.csw.primid.logic.api.IEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.EventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.EventoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author kl.osorio10
 */
@Stateless
public class EventoLogic implements IEventoLogic {

    private static final Logger logger = Logger.getLogger(EventoLogic.class.getName());

    @Inject
    private EventoPersistence persistence;


    public List<EventoEntity> getEventos() {

        logger.info("Inicia proceso de consultar todos los eventos");
        List<EventoEntity> eventos = persistence.findAll();
        logger.info("Termina proceso de consultar todos los eventos");
        return eventos;
}


    public void deleteEvento(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar evento con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar evento con id={0}", id);
    }


    public EventoEntity getEvento(Long id){
     logger.log(Level.INFO, "Inicia proceso de consultar evento con id={0}", id);
     EventoEntity evento = persistence.find(id);
        logger.log(Level.INFO, "Termina proceso de consultar evento con id={0}", id);
        return evento;
    }


    public EventoEntity createEvento(EventoEntity entity){
        logger.info("Inicia proceso de creación de evento");
        persistence.create(entity);
        logger.info("Termina proceso de creación de evento");
        return entity;
    }


    public EventoEntity updateEvento(EventoEntity entity){
               logger.log(Level.INFO, "Inicia proceso de actualizar evento con id={0}", entity.getId());
        EventoEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar evento con id={0}", entity.getId());
        return newEntity;    }

}