
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.api;
import co.edu.uniandes.csw.primid.logic.entities.EventoEntity;
import java.util.List;
/**
 *
 * @author kl.osorio10
 */
public interface IEventoLogic {

    public List<EventoEntity> getEventos();

    public EventoEntity getEvento(Long id);

    public EventoEntity createEvento(EventoEntity entity);

    public EventoEntity updateEvento(EventoEntity entity);

    public void deleteEvento(Long id);

}
