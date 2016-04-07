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

    private MultimediaConverter()
    {

    }

    public static MultimediaDTO refEntity2DTO(MultimediaEntity entity){
        if(entity!=null){
            MultimediaDTO dto = new MultimediaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setRuta(entity.getRuta());
            dto.setTipo(entity.getTipo());
            return dto;
        }
        else{
            return null;
        }
    }

    /**
     * Realiza la conversión de MultimediaDTO a MultimediaEntity Se invoca cuando otro DTO
     * tiene una referencia a MultimediaDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de MultimediaDTO a convertir
     * @return instancia de MultimediaEntity con los datos recibidos por parámetro
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
     * Convierte una instancia de MultimediaEntity a MultimediaDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de MultimediaEntity a convertir
     * @return Instancia de BookDTO con los datos recibidos por parámetro
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
            dto.setItinerario(ItinerarioConverter.basicEntity2DTO(entity.getItinerario()));
            dto.setPlanCiudad(PlanCiudadConverter.basicEntity2DTO(entity.getPlanCiudad()));//si sigue con error es que no esta el converter
            dto.setPlanEvento(PlanEventoConverter.basicEntity2DTO(entity.getPlanEvento()));//si sigue con error es del converter

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de MultimediaDTO a MultimediaEntity Se invoca cuando se
     * necesita convertir una instancia de MultimediaDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
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
            entity.setItinerario(ItinerarioConverter.refDTO2Entity(dto.getItinerario()));
            entity.setPlanCiudad(PlanCiudadConverter.refDTO2Entity(dto.getPlanCiudad()));//si sigue con error es que no esta el converter de plan...
            entity.setPlanEvento(PlanEventoConverter.refDTO2Entity(dto.getPlanEvento()));//si sigue con error es del converter de plan..

            return entity;
        } else {
            return null;
        }
    }

/**
     * Convierte una colección de instancias de MultimediaEntity a MultimediaDTO. Para cada
     * instancia de MultimediaEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo MultimediaDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de MultimediaDTO
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