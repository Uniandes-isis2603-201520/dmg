/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.resources;

import java.util.List;
import javax.ws.rs.GET;
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
    public List<MultimediasDTO> get()
    {
        return multimediaLogic.getMultimedia();
    }

}
