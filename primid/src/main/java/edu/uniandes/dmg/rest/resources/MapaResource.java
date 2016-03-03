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
 * @author fa.vera10
 */
@Path("mapa")
@Produces("application/json")
public class MapaResource {

    @GET
    public List<CityDTO> getCities(){
        return null;
    }

}
