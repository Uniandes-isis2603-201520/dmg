/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.persistence;

import co.edu.uniandes.csw.primid.logic.entities.EventoEntity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author kl.osorio10
 */
@RunWith(Arquillian.class)
public class EventoPersistenceTest {

    @Inject
    private EventoPersistence eventoPersistence;
    @PersistenceContext
    private EntityManager em;
    private final PodamFactory factory = new PodamFactoryImpl();

    public EventoPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EventoEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");

    }

    @Test
    public void creatEventotest() {
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);
        EventoEntity result = eventoPersistence.create(newEntity);

        Assert.assertNotNull(result);
        EventoEntity entity = em.find(EventoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPlace(), entity.getPlace());
        Assert.assertEquals(newEntity.getCategory(), entity.getCategory());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());

    }


}
