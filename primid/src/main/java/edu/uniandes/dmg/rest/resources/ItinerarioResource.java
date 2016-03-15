/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import edu.uniandes.dmg.rest.dtos.ItinerarioDTO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path ("itinerario")
@Produces("application/json")
public class ItinerarioResource {
    
    

     @GET
    public List<ItinerarioDTO> getItinerarios()  {
        return null;
    }
    
         @GET
    public List<ItinerarioDTO> getItinerario(int id)  {
        return null;
    }
    
         @POST
    public List<ItinerarioDTO> postItinerario()  {
        return null;
    }
    
    
         @PUT
    public List<ItinerarioDTO> putItinerario(int id)  {
        return null;
    }
    
    
         @DELETE
    public List<ItinerarioDTO> deleteItinerario(int id)  {
        return null;
    }
    
}
