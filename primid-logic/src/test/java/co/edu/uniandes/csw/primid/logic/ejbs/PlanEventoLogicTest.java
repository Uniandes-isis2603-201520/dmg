/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IPlanEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.PlanEventoPersistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author s.gonzalez22
 */
@RunWith(Arquillian.class)
public class PlanEventoLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IPlanEventoLogic planEventoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PlanEventoEntity> data = new ArrayList<PlanEventoEntity>();

    private List<PlanCiudadEntity> planCiudadData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PlanEventoEntity.class.getPackage())
                .addPackage(PlanEventoLogic.class.getPackage())
                .addPackage(IPlanEventoLogic.class.getPackage())
                .addPackage(PlanEventoPersistence.class.getPackage())
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
        em.createQuery("delete from PlanEventoEntity").executeUpdate();
        em.createQuery("delete from PlanCiudadEntity").executeUpdate();
    }

    private void insertData() {

        /**
         * for (int i = 0; i < 3; i++) { PlanCiudadEntity plan =
         * factory.manufacturePojo(PlanCiudadEntity.class); em.persist(plan);
         * planCiudadData.add(plan); }
         */
        for (int i = 0; i < 3; i++) {
            PlanEventoEntity entity = factory.manufacturePojo(PlanEventoEntity.class);

            em.persist(entity);
            data.add(entity);

            //planCiudadData.get(0).getPlanEventos().add(entity);
        }
    }

    @Test
    public void createPlanEventoTest() {
        PlanEventoEntity expected = factory.manufacturePojo(PlanEventoEntity.class);
        PlanEventoEntity created = planEventoLogic.createPlanEvento(expected);

        PlanEventoEntity result = em.find(PlanEventoEntity.class, created.getId());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());

    }

    @Test
    public void getPlanEventoTest() {
        PlanEventoEntity result = planEventoLogic.getPlanEvento(data.get(0).getId());

        PlanEventoEntity expected = em.find(PlanEventoEntity.class, data.get(0).getId());

        Assert.assertNotNull(expected);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());

    }

    @Test
    public void deletePlanEventoTest() {
        PlanEventoEntity entity = data.get(1);
        planEventoLogic.deletePlanEvento(entity.getId());
        PlanEventoEntity expected = em.find(PlanEventoEntity.class, entity.getId());
        Assert.assertNull(expected);
    }

    @Test
    public void updatePlanEventoTest() {
        PlanEventoEntity entity = data.get(0);
        PlanEventoEntity expected = factory.manufacturePojo(PlanEventoEntity.class);

        expected.setId(entity.getId());

        planEventoLogic.updatePlanEvento(expected);

        PlanEventoEntity resp = em.find(PlanEventoEntity.class, entity.getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), resp.getId());
        Assert.assertEquals(expected.getName(), resp.getName());

    }

}
