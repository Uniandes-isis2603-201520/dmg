/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.mocks;

import co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.rest.aplication.dtos.EventoDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author karenlorenaosoriohenao
 */
@ApplicationScoped
public class EventoLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EventoLogicMock.class.getName());

    // listado de eventos
    private static ArrayList<EventoDTO> eventos;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public EventoLogicMock() {

        if (eventos == null) {
            eventos = new ArrayList();

        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información
        logger.info("Inicializa la lista de eventos");
        logger.info("Eventos" + eventos);
    }

    /**
     * Obtiene el listado de eventos
     *
     * @return lista de eventos
     * @throws PrimidLogicException cuando no existe la lista en memoria
     */
    public List<EventoDTO> getEventos() throws PrimidLogicException {
        if (eventos == null) {
            logger.severe("Error interno: lista de eventos no existe.");
            throw new PrimidLogicException("Error interno: lista de eventos no existe.");
        }

        logger.info("retornando todos los eventos");
        return eventos;
    }

    /**
     * Obtiene el listado de eventos
     *
     * @return lista de eventos
     * @throws PrimidLogicException cuando no existe la lista en memoria
     */
    public List<EventoDTO> getEventosViajero() throws PrimidLogicException {
        if (eventos == null) {
            logger.severe("Error interno: lista de eventos no existe.");
            throw new PrimidLogicException("Error interno: lista de eventos no existe.");
        }

        logger.info("retornando todos los eventos");
        return eventos;
    }

    /**
     * Obtiene un evento
     *
     * @param id identificador del evento
     * @return evento encontrado
     * @throws PrimidLogicException cuando el evento no existe
     */
    public EventoDTO getEventoViajero(Long id) throws PrimidLogicException {
        logger.info("recibiendo solicitud del evento con id " + id);

        // busca el evento con el id suministrado
        for (EventoDTO evento : eventos) {
            if (Objects.equals(evento.getId(), id)) {
                logger.info("retornando ciudad " + evento);
                return evento;
            }
        }

        // si no encuentrael evento
        logger.severe("No existe evento con ese id");
        throw new PrimidLogicException("No existe evento con ese id");
    }

    /**
     * Obtiene un evento
     *
     * @param id identificador del evento
     * @return evento encontrado
     * @throws PrimidLogicException cuando el evento no existe
     */
    public EventoDTO getEvento(Long id) throws PrimidLogicException {
        logger.info("recibiendo solicitud del evento con id " + id);

        // busca el evento con el id suministrado
        for (EventoDTO evento : eventos) {
            if (Objects.equals(evento.getId(), id)) {
                logger.info("retornando ciudad " + evento);
                return evento;
            }
        }

        // si no encuentrael evento
        logger.severe("No existe evento con ese id");
        throw new PrimidLogicException("No existe evento con ese id");
    }

    /**
     * Agrega un evento a la lista.
     *
     * @param newEvento evento a adicionar
     * @throws EventoLogicException cuando ya existe un evento con el id
     * suministrado
     * @return evento agregado
     */
    public EventoDTO createEvento(EventoDTO newEvento) throws PrimidLogicException {
        logger.info("recibiendo solicitud de agregar evento " + newEvento);

        // el nuevo evento tiene id ?
        if (newEvento.getId() != null) {
            // busca el evento con el id suministrado
            for (EventoDTO evento : eventos) {
                // si existe un evento con ese id
                if (Objects.equals(evento.getId(), newEvento.getId())) {
                    logger.severe("Ya existe un evento con ese id");
                    throw new PrimidLogicException("Ya existe un evento con ese id");
                }
            }

            // el nuevo evento no tiene id ?
        } else {

            // genera un id para el evento
            logger.info("Generando id para el nuevo evento");
            long newId = 1;
            for (EventoDTO evento : eventos) {
                if (newId <= evento.getId()) {
                    newId = evento.getId() + 1;
                }
            }
            newEvento.setId(newId);
        }

        // agrega el evento
        logger.info("agregando evento " + newEvento);
        eventos.add(newEvento);
        return newEvento;
    }

    /**
     * Actualiza los datos de un evento
     *
     * @param id identificador dl evento a modificar
     * @param updatedEvento evento a modificar
     * @return datos del evento modificado
     * @throws PrimidLogicException cuando no existe un evento con el id
     * suministrado
     */
    public EventoDTO updateEvento(Long id, EventoDTO updatedEvento) throws PrimidLogicException {
        logger.info("recibiendo solictud de modificar evento " + updatedEvento);

        // busca el evento con el id suministrado
        for (EventoDTO evento : eventos) {
            if (Objects.equals(evento.getId(), id)) {

                // modifica el evento
                evento.setId(updatedEvento.getId());
                evento.setName(updatedEvento.getName());

                // retorna el evento modificado
                logger.info("Modificando evento " + evento);
                return evento;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un evento con ese id");
        throw new PrimidLogicException("No existe un evento con ese id");
    }

    /**
     * Elimina los datos de un evento
     *
     * @param id identificador del evento a eliminar
     * @throws PrimidLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    public void deleteEvento(Long id) throws PrimidLogicException {
        logger.info("recibiendo solictud de eliminar evento con id " + id);

        // busca el evento con el id suministrado
        for (EventoDTO evento : eventos) {
            if (Objects.equals(evento.getId(), id)) {

                // elimina el evento
                logger.info("eliminando evento " + evento);
                eventos.remove(evento);
                return;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un evento con ese id");
        throw new PrimidLogicException("No existe un evento con ese id");
    }

}
