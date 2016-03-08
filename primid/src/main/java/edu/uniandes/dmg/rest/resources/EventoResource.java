/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import edu.uniandes.dmg.rest.dtos.EventoDTO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    public List<EventoDTO> getEventos()  {
        return null;
    }
    
         @GET
    public List<EventoDTO> getEvento(int id)  {
        return null;
    }
    
         @POST
    public List<EventoDTO> postEvento()  {
        return null;
    }
    
    
         @PUT
    public List<EventoDTO> putEvento(int id)  {
        return null;
    }
    
    
         @DELETE
    public List<EventoDTO> deleteEvento(int id)  {
        return null;
    }
    
}
