
package edu.uniandes.dmg.rest.mocks;

import edu.uniandes.dmg.rest.dtos.ViajeroDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/*
 * ViajeroLogicMock
 * Mock del recurso viajero (Mock del servicio REST)
 * Objeto de transferencia de datos de Viajeros.
 * @author jd.torres11
 */
@Named
@ApplicationScoped
public class ViajeroLogicMock {


	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(ViajeroLogicMock.class.getName());

	// listado de ciudades
            private static ArrayList<ViajeroDTO> viajeros;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ViajeroLogicMock() {

    	if (viajeros == null) {
            viajeros = new ArrayList<>();
            viajeros.add(new ViajeroDTO(1L, "Juan Perez","juan@perez.com","src/images/u1"));
            viajeros.add(new ViajeroDTO(2L, "Manuel","manuel@perez.com","src/images/u2"));
            viajeros.add(new ViajeroDTO(3L, "Pepita Perez","pepita@perez.com","src/images/u3"));
        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + viajeros );
}
}
