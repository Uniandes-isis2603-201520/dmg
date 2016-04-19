/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;

import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import static org.glassfish.pfl.basic.tools.argparser.ElementParser.factory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Sebastian
 */
@RunWith(Arquillian.class)
public class PlanEventoPersistenceTest {


    @Inject
    private PlanEventoPersistence planEventoPersistence;
    @PersistenceContext
    private EntityManager em ;
    @Inject
    UserTransaction utx;
    private final PodamFactory factory = new PodamFactoryImpl();


     @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from PlanEventoEntity").executeUpdate();
    }

    private List<PlanEventoEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PlanEventoEntity entity = factory.manufacturePojo(PlanEventoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    public PlanEventoPersistenceTest() {

    }

    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PlanEventoEntity.class.getPackage())
                .addPackage(PlanEventoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");

    }

    @Test
    public void createPlanEventoTest() {

        PlanEventoEntity newEntity= factory.manufacturePojo(PlanEventoEntity.class);

        PlanEventoEntity result = planEventoPersistence.create(newEntity);


        Assert.assertNotNull(result);

         PlanEventoEntity entity = em.find(PlanEventoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }


    @Test
    public void getPlanEventosTest() {
        List<PlanEventoEntity> list = planEventoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PlanEventoEntity ent : list) {
            boolean found = false;
            for (PlanEventoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getAuthorTest() {
        PlanEventoEntity entity = data.get(0);
        PlanEventoEntity newEntity = planEventoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());

    }

    @Test
    public void deleteAuthorTest() {
        PlanEventoEntity entity = data.get(0);
        planEventoPersistence.delete(entity.getId());
        PlanEventoEntity deleted = em.find(PlanEventoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updatePlanEventoTest() {
        PlanEventoEntity entity = data.get(0);
        PlanEventoEntity newEntity = factory.manufacturePojo(PlanEventoEntity.class);

        newEntity.setId(entity.getId());

        planEventoPersistence.update(newEntity);

        PlanEventoEntity resp = em.find(PlanEventoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }


}
