/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import edu.uniandes.dmg.rest.dtos.EventoDTO;
import edu.uniandes.dmg.rest.dtos.MultimediaDTO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author fa.lopez10
 */
@Path("multimedia")
@Produces("application/json")
public class MultimediaResource {
 @GET
    public List<MultimediaDTO> getMultimedia()  {
        return null;
    }

         @GET
    public List<MultimediaDTO> getArchivoMultimedia(int id)  {
        return null;
    }

         @POST
    public List<MultimediaDTO> postMultimedia()  {
        return null;
    }


         @PUT
    public List<MultimediaDTO> putMultimedia(int id)  {
        return null;
    }


         @DELETE
    public List<MultimediaDTO> deleteMultimedia(int id)  {
        return null;
    }
    //logger: funciona como sysout, se pueden desactivar


}
