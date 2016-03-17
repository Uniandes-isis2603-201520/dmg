/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.exceptions;

/*
 *  Representa las excepciones de la lógica de Primid
 * @author jd.torres11
 */
public class PrimidLogicException extends Exception{
        /**
        * versión usada en la serialización de la clase
         */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor por defecto
	 */
	public PrimidLogicException() {
	}

	/*
	 * Constructor con un mensaje
	 * @param message mensaje de la excepción
	 */
	public PrimidLogicException(String message) {
		super(message);
	}

        /*
	 * Constructor con una causa
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public PrimidLogicException(Throwable cause) {
		super(cause);
	}
        /*
	 * Constructor con mensaje y causa.
	 * @param message mensaje de la excepción
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public PrimidLogicException(String message, Throwable cause) {
		super(message, cause);
	}
}
