/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.dmg.rest.converters;

import edu.uniandes.dmg.rest.exceptions.PrimidLogicException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
 * Convertidor de Excepciones CityLogicException a mensajes REST.
 * @author jd.torres11
 */
@Provider
public class PrimidLogicExceptionMapper implements ExceptionMapper<PrimidLogicException>{

    /**
	 * Generador de una respuesta a partir de una excepción
	 * @param exeption excecpión a convertir a una respuesta REST
	 */
    @Override
    public Response toResponse(PrimidLogicException exception) {
    // retorna una respuesta
		return Response
				.status(Response.Status.NOT_FOUND)	// estado HTTP 404
				.entity(exception.getMessage())			// mensaje adicional
				.type("text/plain")
				.build();

    }



}
