/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.entities;

import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author la.mesa10
 */
@Entity
public class ItinerarioEntity extends BaseEntity implements Serializable
{
    @OneToMany(mappedBy ="Itinerario")
    private List<ItinerarioEntity> itinerarios= new ArrayList<>();

    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerarios;
    }
    public void setItinerarios (List<ItinerarioEntity> pItinerarios)
    {
        itinerarios = pItinerarios;
    }
}
