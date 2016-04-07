/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.converters;

import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.rest.aplication.dtos.PlanEventoDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author s.gonzalez22
 */
public abstract class PlanEventoConverter {



     /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private PlanEventoConverter() {
    }

    /**
     * Realiza la conversión de AuthorEntity a AuthorDTO.
     * Se invoca cuando otra entidad tiene una referencia a AuthorEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de AuthorEntity a convertir
     * @return instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PlanEventoDTO refEntity2DTO(PlanEventoEntity entity) {
        if (entity != null) {
            PlanEventoDTO dto = new PlanEventoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaFin(entity.getFechaFin());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de AuthorDTO a AuthorEntity Se invoca cuando otro DTO
     * tiene una referencia a AuthorDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de AuthorDTO a convertir
     * @return instancia de AuthorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PlanEventoEntity refDTO2Entity(PlanEventoDTO dto) {
        if (dto != null) {
            PlanEventoEntity entity = new PlanEventoEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorEntity a AuthorDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de AuthorEntity a convertir
     * @return Instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    private static PlanEventoDTO basicEntity2DTO(PlanEventoEntity entity) {
        if (entity != null) {
            PlanEventoDTO dto = new PlanEventoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setFechaInicio(entity.getFechaInicio());
            dto.setFechaFin(entity.getFechaFin());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorDTO a AuthorEntity Se invoca cuando se
     * necesita convertir una instancia de AuthorDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de AuthorDTO a convertir
     * @return Instancia de AuthorEntity creada a partir de los datos de dto
     * @generated
     */
    private static PlanEventoEntity basicDTO2Entity(PlanEventoDTO dto) {
        if (dto != null) {
            PlanEventoEntity entity = new PlanEventoEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setFechaInicio(dto.getFechaInicio());
            entity.setFechaFin(dto.getFechaFin());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de AuthorEntity a AuthorDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de AuthorEntity a convertir
     * @return Instancia de AuthorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PlanEventoDTO fullEntity2DTO(PlanEventoEntity entity) {
        if (entity != null) {
            PlanEventoDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de AuthorDTO a AuthorEntity.
     * Incluye todos los atributos de AuthorEntity.
     *
     * @param dto Instancia de AuthorDTO a convertir
     * @return Instancia de AuthorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static PlanEventoEntity fullDTO2Entity(PlanEventoDTO dto) {
        if (dto != null) {
            PlanEventoEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de AuthorEntity a AuthorDTO. Para cada
     * instancia de AuthorEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo AuthorDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de AuthorDTO
     * @generated
     */
    public static List<PlanEventoDTO> listEntity2DTO(List<PlanEventoEntity> entities) {
        List<PlanEventoDTO> dtos = new ArrayList<PlanEventoDTO>();
        if (entities != null) {
            for (PlanEventoEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de AuthorDTO a instancias de
     * AuthorEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de AuthorDTO a convertir
     * @return Collección de instancias de AuthorEntity
     * @generated
     */
    public static List<PlanEventoEntity> listDTO2Entity(List<PlanEventoDTO> dtos) {
        List<PlanEventoEntity> entities = new ArrayList<PlanEventoEntity>();
        if (dtos != null) {
            for (PlanEventoDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }


}
