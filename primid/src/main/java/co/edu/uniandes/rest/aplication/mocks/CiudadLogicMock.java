/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.mocks;

import co.edu.uniandes.rest.aplication.exceptions.PrimidLogicException;
import co.edu.uniandes.rest.aplication.dtos.CiudadDTO;
import java.util.ArrayList;
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
public class CiudadLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(CiudadLogicMock.class.getName());

    // listado de eventos
    private static ArrayList<CiudadDTO> ciudades;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public CiudadLogicMock() {

        if (ciudades == null) {
            ciudades = new ArrayList();

        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información
        logger.info("Inicializa la lista de ciudades");
        logger.info("Ciudades" + ciudades);
    }

    /**
     * Obtiene el listado de eventos
     *
     * @return lista de eventos
     * @throws PrimidLogicException cuando no existe la lista en memoria
     */
    public List<CiudadDTO> getCiudades() throws PrimidLogicException {
        if (ciudades == null) {
            logger.severe("Error interno: lista de ciudades no existe.");
            throw new PrimidLogicException("Error interno: lista de ciudades no existe.");
        }

        logger.info("retornando todos los ciudades");
        return ciudades;
    }

    /**
     * Obtiene el listado de eventos
     *
     * @return lista de eventos
     * @throws PrimidLogicException cuando no existe la lista en memoria
     */
    public List<CiudadDTO> getCiudadesViajero() throws PrimidLogicException {
        if (ciudades == null) {
            logger.severe("Error interno: lista de ciudades no existe.");
            throw new PrimidLogicException("Error interno: lista de ciudades no existe.");
        }

        logger.info("retornando todos los ciudades");
        return ciudades;
    }

    /**
     * Obtiene un evento
     *
     * @param id identificador del evento
     * @return evento encontrado
     * @throws PrimidLogicException cuando el evento no existe
     */
    public CiudadDTO getCiudadViajero(Long id) throws PrimidLogicException {
        logger.info("recibiendo solicitud de la ciudad con id " + id);

        // busca el evento con el id suministrado
        for (CiudadDTO ciudad : ciudades) {
            if (Objects.equals(ciudad.getId(), id)) {
                logger.info("retornando ciudad " + ciudad);
                return ciudad;
            }
        }

        // si no encuentrael evento
        logger.severe("No existe ciudad con ese id");
        throw new PrimidLogicException("No existe ciudad con ese id");
    }

    /**
     * Obtiene un evento
     *
     * @param id identificador del evento
     * @return evento encontrado
     * @throws PrimidLogicException cuando el evento no existe
     */
    public CiudadDTO getCiudad(Long id) throws PrimidLogicException {
        logger.info("recibiendo solicitud del ciudad con id " + id);

        // busca el evento con el id suministrado
        for (CiudadDTO ciudad : ciudades) {
            if (Objects.equals(ciudad.getId(), id)) {
                logger.info("retornando ciudad " + ciudad);
                return ciudad;
            }
        }

        // si no encuentrael evento
        logger.severe("No existe ciudad con ese id");
        throw new PrimidLogicException("No existe ciudad con ese id");
    }

    /**
     * Agrega un evento a la lista.
     *
     * @param newEvento evento a adicionar
     * @throws EventoLogicException cuando ya existe un evento con el id
     * suministrado
     * @return evento agregado
     */
    public CiudadDTO createCiudad(CiudadDTO newCiudad) throws PrimidLogicException {
        logger.info("recibiendo solicitud de agregar ciudad " + newCiudad);

        // el nuevo evento tiene id ?
        if (newCiudad.getId() != null) {
            // busca el evento con el id suministrado
            for (CiudadDTO ciudad : ciudades) {
                // si existe un evento con ese id
                if (Objects.equals(ciudad.getId(), newCiudad.getId())) {
                    logger.severe("Ya existe un ciudad con ese id");
                    throw new PrimidLogicException("Ya existe un ciudad con ese id");
                }
            }

            // el nuevo evento no tiene id ?
        } else {

            // genera un id para el evento
            logger.info("Generando id para el nuevo evento");
            long newId = 1;
            for (CiudadDTO ciudad : ciudades) {
                if (newId <= ciudad.getId()) {
                    newId = ciudad.getId() + 1;
                }
            }
            newCiudad.setId(newId);
        }

        // agrega el evento
        logger.info("agregando ciudad " + newCiudad);
        ciudades.add(newCiudad);
        return newCiudad;
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
    public CiudadDTO updateCiudad(Long id, CiudadDTO updatedCiudad) throws PrimidLogicException {
        logger.info("recibiendo solictud de modificar ciudad " + updatedCiudad);

        // busca el evento con el id suministrado
        for (CiudadDTO ciudad : ciudades) {
            if (Objects.equals(ciudad.getId(), id)) {

                // modifica el evento
                ciudad.setId(updatedCiudad.getId());
                ciudad.setName(updatedCiudad.getName());

                // retorna el evento modificado
                logger.info("Modificando ciudad " + ciudad);
                return ciudad;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un ciudad con ese id");
        throw new PrimidLogicException("No existe un ciudad con ese id");
    }

    /**
     * Elimina los datos de un evento
     *
     * @param id identificador del evento a eliminar
     * @throws PrimidLogicException cuando no existe una ciudad con el id
     * suministrado
     */
    public void deleteCiudad(Long id) throws PrimidLogicException {
        logger.info("recibiendo solictud de eliminar ciudad con id " + id);

        // busca el evento con el id suministrado
        for (CiudadDTO ciudad : ciudades) {
            if (Objects.equals(ciudad.getId(), id)) {

                // elimina el evento
                logger.info("eliminando ciudad " + ciudad);
                ciudades.remove(ciudad);
                return;
            }
        }

        // no encontró el evento con ese id ?
        logger.severe("No existe un ciudad con ese id");
        throw new PrimidLogicException("No existe un ciudad con ese id");
    }

}
