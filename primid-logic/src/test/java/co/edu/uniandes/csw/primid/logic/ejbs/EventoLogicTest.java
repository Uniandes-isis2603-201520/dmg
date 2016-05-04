/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.EventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.EventoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.arquillian.container.test.api.Deployment;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author kl.osorio10
 */
@RunWith(Arquillian.class)
public class EventoLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IEventoLogic eventoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EventoEntity> data = new ArrayList<EventoEntity>();

        @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EventoEntity.class.getPackage())
                .addPackage(EventoLogic.class.getPackage())
                .addPackage(IEventoLogic.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
        em.createQuery("delete from EventoEntity").executeUpdate();
    }


    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EventoEntity entity = factory.manufacturePojo(EventoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

      @Test
    public void createEventoTest(){
        EventoEntity expected = factory.manufacturePojo(EventoEntity.class);
        EventoEntity created = eventoLogic.createEvento(expected);

        EventoEntity result = em.find(EventoEntity.class, created.getId());

        Assert.assertNotNull(result);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
       }
     @Test
    public void getEventoTest(){
        EventoEntity result = eventoLogic.getEvento(data.get(0).getId());
        EventoEntity expected = em.find(EventoEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
    }

     @Test
    public void deleteEventoTest() {
        EventoEntity entity = data.get(1);
        eventoLogic.deleteEvento(entity.getId());
        EventoEntity expected = em.find(EventoEntity.class, entity.getId());
        Assert.assertNull(expected);
    }

    @Test
    public void updateEventoTest() {
        EventoEntity entity = data.get(0);
        EventoEntity expected = factory.manufacturePojo(EventoEntity.class);

        expected.setId(entity.getId());

        eventoLogic.updateEvento(expected);

        EventoEntity resp = em.find(EventoEntity.class, entity.getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), resp.getId());
        Assert.assertEquals(expected.getName(), resp.getName());
     }

    }

