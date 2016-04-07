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
public class MultimediaConverter {

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
     * Realiza la conversi�n de MultimediaDTO a MultimediaEntity Se invoca cuando otro DTO
     * tiene una referencia a MultimediaDTO Convierte �nicamente el ID ya que es el
     * �nico atributo necesario para guardar la relaci�n en la base de datos
     *
     * @param dto instancia de MultimediaDTO a convertir
     * @return instancia de MultimediaEntity con los datos recibidos por par�metro
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
     * @return Instancia de BookDTO con los datos recibidos por par�metro
     * @generated
     */
    private static MultimediaDTO basicEntity2DTO(MultimediaEntity entity) {
        if (entity != null) {
            MultimediaDTO dto = new MultimediaDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setRuta(entity.getRuta());
            dto.setTipo(entity.getTipo());
            //aqui van los many to one

            return dto;
        } else {
            return null;
        }
    }

/**
     * Convierte una colecci�n de instancias de MultimediaEntity a MultimediaDTO. Para cada
     * instancia de MultimediaEntity en la lista, invoca basicEntity2DTO y a�ade el
     * nuevo MultimediaDTO a una nueva lista
     *
     * @param entities Colecci�n de entidades a convertir
     * @return Collecci�n de instancias de MultimediaDTO
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