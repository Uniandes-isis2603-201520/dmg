/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.converters;

import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.rest.aplication.dtos.PlanCiudadDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jd.torres11
 */
public abstract class PlanCiudadConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito
     * de Java
     *
     * @generated
     */
    private PlanCiudadConverter() {
    }

    /**
     * Realiza la conversión de PlanCiudadEntity a PlanCiudadDTO. Se invoca
     * cuando otra entidad tiene una referencia a PlanCiudadEntity. Entrega
     * únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de PlanCiudadEntity a convertir
     * @return instancia de PlanCiudadDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PlanCiudadDTO refEntity2DTO(PlanCiudadEntity entity) {
        if (entity != null) {
            PlanCiudadDTO dto = new PlanCiudadDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de PlanCiudadDTO a ViajeroEntity Se invoca cuando
     * otro DTO tiene una referencia a PlanCiudadDTO Convierte únicamente el ID
     * ya que es el único atributo necesario para guardar la relación en la
     * base de datos
     *
     * @param dto instancia de ViajeroDTO a convertir
     * @return instancia de PlanCiudadEntity con los datos recibidos por
     * parámetro
     * @generated
     */
    public static PlanCiudadEntity refDTO2Entity(PlanCiudadDTO dto) {
        if (dto != null) {
            PlanCiudadEntity entity = new PlanCiudadEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PlanCiudadEntity a PlanCiudadDTO Se invoca
     * cuando se desea consultar la entidad y sus relaciones muchos a uno o uno
     * a uno
     *
     * @param entity instancia de PlanCiudadEntity a convertir
     * @return Instancia de PlanCiudadDTO con los datos recibidos por parámetro
     * @generated
     */
    private static PlanCiudadDTO basicEntity2DTO(PlanCiudadEntity entity) {
        if (entity != null) {
            PlanCiudadDTO dto = new PlanCiudadDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PlanCiudadDTO a PlanCiudadEntity Se invoca
     * cuando se necesita convertir una instancia de PlanCiudadDTO con los
     * atributos propios de la entidad y con las relaciones uno a uno o muchos a
     * uno
     *
     * @param dto instancia de PlanCiudadDTO a convertir
     * @return Instancia de PlanCiudadEntity creada a partir de los datos de dto
     * @generated
     */
    private static PlanCiudadEntity basicDTO2Entity(PlanCiudadDTO dto) {
        if (dto != null) {
            PlanCiudadEntity entity = new PlanCiudadEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de PlanCiudadEntity a PlanCiudadDTO incluyendo sus
     * relaciones Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de PlanCiudadEntity a convertir
     * @return Instancia de PlanCiudadDTO con los datos recibidos por parámetro
     * @generated
     */
    public static PlanCiudadDTO fullEntity2DTO(PlanCiudadEntity entity) {
        if (entity != null) {
            PlanCiudadDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de PlanCiudadDTO a PlanCiudadEntity. Incluye
     * todos los atributos de PlanCiudadEntity.
     *
     * @param dto Instancia de PlanCiudadDTO a convertir
     * @return Instancia de PlanCiudadEntity con los datos recibidos por
     * parámetro
     * @generated
     */
    public static PlanCiudadEntity fullDTO2Entity(PlanCiudadDTO dto) {
        if (dto != null) {
            PlanCiudadEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de PlanCiudadEntity a
     * PlanCiudadDTO. Para cada instancia de PlanCiudadEntity en la lista,
     * invoca basicEntity2DTO y añade el nuevo PlanCiudadDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de PlanCiudadDTO
     * @generated
     */
    public static List<PlanCiudadDTO> listEntity2DTO(List<PlanCiudadEntity> entities) {
        List<PlanCiudadDTO> dtos = new ArrayList<PlanCiudadDTO>();
        if (entities != null) {
            for (PlanCiudadEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de ViajeroDTO a instancias de
     * ViajeroEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de ViajeroDTO a convertir
     * @return Collección de instancias de ViajeroEntity
     * @generated
     */
    public static List<PlanCiudadEntity> listDTO2Entity(List<PlanCiudadDTO> dtos) {
        List<PlanCiudadEntity> entities = new ArrayList<PlanCiudadEntity>();
        if (dtos != null) {
            for (PlanCiudadDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
