/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import edu.uniandes.dmg.rest.dtos.CityDTO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author karenlorenaosoriohenao
 */
@Path ("viajero")
@Produces("application/json")
public class EventoResource {
    
    //incluir dependencia desde el pomp

     @GET
    public List<CityDTO> getCities()  {
        return null;
    }
    
}
