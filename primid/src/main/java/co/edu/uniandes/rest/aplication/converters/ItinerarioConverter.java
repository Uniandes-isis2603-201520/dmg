/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.aplication.converters;

import edu.uniandes.dmg.co.edu.uniandes.rest.aplication.dtos.ItinerarioDTO;
//import co.edu.uniandes.csw.bookstore.entities.ItinerarioEntity;

/**
 *
 * @author la.mesa10
 */
public abstract class ItinerarioConverter {

    private ItinerarioConverter()
    {

    }

    public static ItinerarioDTO refEntity2DTO(ItinerarioEntity entity) {
        if (entity != null) {
            ItinerarioDTO dto = new IDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setIsbn(entity.getIsbn());
            dto.setImage(entity.getImage());
            dto.setPublishDate(entity.getPublishDate());

            return dto;
        } else {
            return null;
        }
    }

}
