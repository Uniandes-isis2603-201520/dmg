/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IItinerarioLogic;
import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.persistence.ItinerarioPersistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @itinerario la.mesa10
 */
@RunWith(Arquillian.class)
public class ItinerarioLogicTest
{
    private PodamFactory fabrica = new PodamFactoryImpl();

    @Inject
    private IItinerarioLogic itinerarioLogic;

    @PersistenceContext
    private EntityManager manejador;

    @Inject
    private UserTransaction utx;

     private List<ItinerarioEntity> data = new ArrayList<ItinerarioEntity>();

    //private List<PlanCiudadEntity>planesCiudadesData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioLogic.class.getPackage())
                .addPackage(IItinerarioLogic.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    public ItinerarioLogicTest() {
    }

     @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        manejador.createQuery("delete from ItinerarioEntity").executeUpdate();
        //manejador.createQuery("delete from ItinerarioEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ItinerarioEntity itinerario = fabrica.manufacturePojo(ItinerarioEntity.class);
            itinerario.setFechaFin(this.getMaxDate());
            itinerario.setFechaInicio(new Date());
            manejador.persist(itinerario);
            data.add(itinerario);
        }

        //for (int i = 0; i < 3; i++) {
          //  ItinerarioEntity entity = fabrica.manufacturePojo(ItinerarioEntity.class);

            //manejador.persist(entity);
            //data.add(entity);

            //booksData.get(0).getItinerarios().add(entity);
        //}
    }

    @Test
    public void createItinerarioTest() {
        ItinerarioEntity prueba = fabrica.manufacturePojo(ItinerarioEntity.class);
        ItinerarioEntity nuevo = itinerarioLogic.createItinerario(prueba);

        ItinerarioEntity rta = manejador.find(ItinerarioEntity.class, nuevo.getId());

        Assert.assertNotNull(rta);

        Assert.assertEquals(prueba.getId(), rta.getId());
        Assert.assertEquals(nuevo.getName(), rta.getName());
        Assert.assertEquals(prueba.getFechaFin(), rta.getFechaFin());
    }

    @Test
    public void getItinerariosTest() {
        List<ItinerarioEntity> resultList = itinerarioLogic.getItinerarios();
        List<ItinerarioEntity> expectedList = manejador.createQuery("SELECT u from ItinerarioEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (ItinerarioEntity expected : expectedList) {
            boolean found = false;
            for (ItinerarioEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getItinerarioTest() {
        ItinerarioEntity result;
        result = null;
        try {
            result = itinerarioLogic.getItinerario(data.get(0).getId());
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ItinerarioLogicTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        ItinerarioEntity expected = manejador.find(ItinerarioEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
        Assert.assertEquals(expected.getFechaFin(), result.getFechaFin());
    }

    @Test
    public void deleteItinerarioTest() {
        ItinerarioEntity entity = data.get(1);
        itinerarioLogic.deleteItinerario(entity.getId());
        ItinerarioEntity expected = manejador.find(ItinerarioEntity.class, entity.getId());
        Assert.assertNull(expected);
    }

    @Test
    public void updateItinerarioTest() {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity expected = fabrica.manufacturePojo(ItinerarioEntity.class);

        expected.setId(entity.getId());

        itinerarioLogic.updateItinerario(expected);

        ItinerarioEntity resp = manejador.find(ItinerarioEntity.class, entity.getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), resp.getId());
        Assert.assertEquals(expected.getName(), resp.getName());
        Assert.assertEquals(expected.getFechaFin(), resp.getFechaFin());
    }
 private Date getMaxDate() {
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 9999);
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
        return c.getTime();
    }

}
