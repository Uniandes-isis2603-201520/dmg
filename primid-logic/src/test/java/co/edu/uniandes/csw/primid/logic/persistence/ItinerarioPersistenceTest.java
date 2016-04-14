/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;

import org.junit.Test;
import static org.junit.Assert.*;
import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author la.mesa10
 */
@RunWith(Arquillian.class)
public class ItinerarioPersistenceTest
{
    @Inject
    private ItinerarioPersistence itinerarioP;
    @PersistenceContext
    private EntityManager manejador;
    private final PodamFactory fabrica = new PodamFactoryImpl();

    private List<ItinerarioEntity> data = new ArrayList<>();


    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    @Test
    public void createItinerarioTest()
    {
        ItinerarioEntity nuevaEntidad = fabrica.manufacturePojo(ItinerarioEntity.class);
        ItinerarioEntity resultado = itinerarioP.create(nuevaEntidad);

        Assert.assertNotNull(resultado);

        ItinerarioEntity encontrado= manejador.find(ItinerarioEntity.class, resultado.getId());
        Assert.assertEquals(encontrado.getName(),nuevaEntidad.getName());
        Assert.assertEquals(encontrado.getFechaFin(),nuevaEntidad.getFechaFin());
        Assert.assertEquals(encontrado.getFechaInicio(),nuevaEntidad.getFechaInicio());

    }
    @Test
    public void getItinerariosTest() {
        List<ItinerarioEntity> list = itinerarioP.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ItinerarioEntity ent : list) {
            boolean found = false;
            for (ItinerarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
     public ItinerarioPersistenceTest() {
    }

    @Test
    public void testSomeMethod() {
    }
}
