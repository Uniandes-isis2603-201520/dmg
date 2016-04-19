/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;

import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class MultimediaPersistenceTest {

    @Inject
    private MultimediaPersistence multimediaPersistence;
    @PersistenceContext
    private EntityManager em;
    private final PodamFactory factory = new PodamFactoryImpl();
    @Inject
    UserTransaction utx;

    public MultimediaPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MultimediaEntity.class.getPackage())
                .addPackage(MultimediaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }

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
        em.createQuery("delete from MultimediaEntity").executeUpdate();
    }

    private List<MultimediaEntity> data = new ArrayList<>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            MultimediaEntity entity = factory.manufacturePojo(MultimediaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createMultimediaTest() {
        MultimediaEntity newEntity = factory.manufacturePojo(MultimediaEntity.class);

        MultimediaEntity result = multimediaPersistence.create(newEntity);

        Assert.assertNotNull(result);
        MultimediaEntity entity = em.find(MultimediaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(),entity.getName());
        Assert.assertEquals(newEntity.getTipo(),entity.getTipo());
        Assert.assertEquals(newEntity.getRuta(),entity.getRuta());
    }

    @Test
    public void getMultimediaTest() {
        List<MultimediaEntity> list = multimediaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MultimediaEntity ent : list) {
            boolean found = false;
            for (MultimediaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getArchivoMultimediaTest() {
        MultimediaEntity entity = data.get(0);
        MultimediaEntity newEntity = multimediaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getName(),entity.getName());
        Assert.assertEquals(newEntity.getTipo(),entity.getTipo());
        Assert.assertEquals(newEntity.getRuta(),entity.getRuta());

    }

    @Test
    public void deleteMultimediaTest() {
        MultimediaEntity entity = data.get(0);
        multimediaPersistence.delete(entity.getId());
        MultimediaEntity deleted = em.find(MultimediaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateMultimediaTest() {
        MultimediaEntity entity = data.get(0);
        MultimediaEntity newEntity = factory.manufacturePojo(MultimediaEntity.class);

        newEntity.setId(entity.getId());

        multimediaPersistence.update(newEntity);

        MultimediaEntity resp = em.find(MultimediaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

}