/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IMultimediaLogic;
import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanCiudadEntity;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.persistence.MultimediaPersistence;
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
 * @author fa.lopez10
 */
@RunWith(Arquillian.class)
public class MultimediaLogicTest {


    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IMultimediaLogic multimediaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<MultimediaEntity> data = new ArrayList<MultimediaEntity>();

    private List<PlanEventoEntity> planEventoData = new ArrayList<>();

    private List<PlanCiudadEntity> planCiudadData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MultimediaEntity.class.getPackage())
                .addPackage(MultimediaLogic.class.getPackage())
                .addPackage(IMultimediaLogic.class.getPackage())
                .addPackage(MultimediaPersistence.class.getPackage())
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
        em.createQuery("delete from MultimediaEntity").executeUpdate();
    }

    private void insertData() {

        for (int i = 0; i < 3; i++) {
            MultimediaEntity entity = factory.manufacturePojo(MultimediaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createArchivoMultimediaTest() {
        try {
            MultimediaEntity entity = factory.manufacturePojo(MultimediaEntity.class);
            MultimediaEntity result = multimediaLogic.createArchivoMultimedia(entity);

            MultimediaEntity resp = em.find(MultimediaEntity.class, result.getId());

            Assert.assertNotNull(result);
            Assert.assertEquals(entity.getId(), resp.getId());
            Assert.assertEquals(entity.getName(), resp.getName());
            Assert.assertEquals(entity.getTipo(), resp.getTipo());
            Assert.assertEquals(entity.getRuta(), resp.getRuta());
        } catch (Exception ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }

    @Test
    public void getMultimediaTest() {
        List<MultimediaEntity> list = multimediaLogic.getMultimedia();
        Assert.assertEquals(data.size(), list.size());
        for (MultimediaEntity entity : list) {
            boolean found = false;
            for (MultimediaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getArchivoMultimediaTest() {
        MultimediaEntity entity = data.get(0);
        MultimediaEntity resultEntity = multimediaLogic.getArchivoMultimedia(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getRuta(), resultEntity.getRuta());
        Assert.assertEquals(entity.getTipo(), resultEntity.getTipo());
    }

    @Test
    public void deleteArchivoMultimediaTest() {
        MultimediaEntity entity = data.get(1);
        multimediaLogic.deleteArchivoMultimedia(entity.getId());
        MultimediaEntity deleted = em.find(MultimediaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateArchivoMultimediaTest() {
        try {
            MultimediaEntity entity = data.get(0);
            MultimediaEntity pojoEntity = factory.manufacturePojo(MultimediaEntity.class);

            pojoEntity.setId(entity.getId());

            multimediaLogic.updateArchivoMultimedia(pojoEntity);

            MultimediaEntity resp = em.find(MultimediaEntity.class, entity.getId());

            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getName(), resp.getName());
            Assert.assertEquals(pojoEntity.getRuta(), resp.getRuta());
            Assert.assertEquals(pojoEntity.getTipo(), resp.getTipo());
        } catch (Exception ex) {
            Assert.fail(ex.getLocalizedMessage());
        }
    }


}
