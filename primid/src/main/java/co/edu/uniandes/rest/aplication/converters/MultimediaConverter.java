/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.converters;

import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.rest.aplication.dtos.MultimediaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fa.lopez10
 */
public abstract class MultimediaConverter {

    private MultimediaConverter() {

    }

    public static MultimediaDTO refEntity2DTO(MultimediaEntity entity) {
        if (entity != null) {
            MultimediaDTO dto = new MultimediaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setRuta(entity.getRuta());
            dto.setTipo(entity.getTipo());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversion de MultimediaDTO a MultimediaEntity Se invoca
     * cuando otro DTO tiene una referencia a MultimediaDTO Convierte unicamente
     * el ID ya que es el unico atributo necesario para guardar la relacion en
     * la base de datos
     *
     * @param dto instancia de MultimediaDTO a convertir
     * @return instancia de MultimediaEntity con los datos recibidos por
     * parametro
     * @generated
     */
    public static MultimediaEntity refDTO2Entity(MultimediaDTO dto) {
        if (dto != null) {
            MultimediaEntity entity = new MultimediaEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de MultimediaEntity a MultimediaDTO Se invoca
     * cuando se desea consultar la entidad y sus relaciones muchos a uno o uno
     * a uno
     *
     * @param entity instancia de MultimediaEntity a convertir
     * @return Instancia de MultimediaDTO con los datos recibidos por parametro
     * @generated
     */
    public static MultimediaDTO basicEntity2DTO(MultimediaEntity entity) {
        if (entity != null) {
            MultimediaDTO dto = new MultimediaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setRuta(entity.getRuta());
            dto.setTipo(entity.getTipo());
            //aqui van los many to one
            dto.setPlanCiudad(PlanCiudadConverter.refEntity2DTO(entity.getPlanCiudad()));
            dto.setPlanEvento(PlanEventoConverter.refEntity2DTO(entity.getPlanEvento()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de MultimediaDTO a MultimediaEntity Se invoca
     * cuando se necesita convertir una instancia de MultimediaDTO con los
     * atributos propios de la entidad y con las relaciones uno a uno o muchos a
     * uno
     *
     * @param dto instancia de MultimediaDTO a convertir
     * @return Instancia de MultimediaEntity creada a partir de los datos de dto
     * @generated
     */
    public static MultimediaEntity basicDTO2Entity(MultimediaDTO dto) {
        if (dto != null) {
            MultimediaEntity entity = new MultimediaEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setRuta(dto.getRuta());
            entity.setTipo(dto.getTipo());
            //relaciones entre recursos

            entity.setPlanCiudad(PlanCiudadConverter.refDTO2Entity(dto.getPlanCiudad()));
            entity.setPlanEvento(PlanEventoConverter.refDTO2Entity(dto.getPlanEvento()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una coleccion de instancias de MultimediaEntity a
     * MultimediaDTO. Para cada instancia de MultimediaEntity en la lista,
     * invoca basicEntity2DTO y anade el nuevo MultimediaDTO a una nueva lista
     *
     * @param entities coleccion de entidades a convertir
     * @return colleccion de instancias de MultimediaDTO
     * @generated
     */
    public static List<MultimediaDTO> listEntity2DTO(List<MultimediaEntity> entities) {
        List<MultimediaDTO> dtos = new ArrayList<MultimediaDTO>();
        if (entities != null) {
            for (MultimediaEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }
}
