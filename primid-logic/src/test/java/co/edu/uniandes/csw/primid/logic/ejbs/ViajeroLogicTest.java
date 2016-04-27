package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IViajeroLogic;
import co.edu.uniandes.csw.primid.logic.entities.ItinerarioEntity;
import co.edu.uniandes.csw.primid.logic.entities.ViajeroEntity;
import co.edu.uniandes.csw.primid.logic.persistence.ViajeroPersistence;
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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import javax.persistence.Query;

/**
 *
 * @author jd.torres11
 */
@RunWith(Arquillian.class)
public class ViajeroLogicTest {

    public ViajeroLogicTest() {
    }
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private IViajeroLogic viajeroLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ViajeroEntity> data = new ArrayList<ViajeroEntity>();

    private List<ItinerarioEntity> itinerariosData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ViajeroEntity.class.getPackage())
                .addPackage(ViajeroLogic.class.getPackage())
                .addPackage(IViajeroLogic.class.getPackage())
                .addPackage(ViajeroPersistence.class.getPackage())
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
        // em.createQuery("delete from BookEntity").executeUpdate();
        em.createQuery("delete from ViajeroEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ItinerarioEntity itinerarios = factory.manufacturePojo(ItinerarioEntity.class);
            em.persist(itinerarios);
            itinerariosData.add(itinerarios);
        }
        for (int i = 0; i < 3; i++) {
            ViajeroEntity entity = factory.manufacturePojo(ViajeroEntity.class);
            em.persist(entity);
            data.add(entity);

        }
    }

    @Test
    public void createViajeroTest() {
        ViajeroEntity expected = factory.manufacturePojo(ViajeroEntity.class);
        ViajeroEntity created = viajeroLogic.createViajero(expected);

        ViajeroEntity result = em.find(ViajeroEntity.class, created.getId());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
        Assert.assertEquals(expected.getBirthDate(), result.getBirthDate());
    }

    @Test
    public void getViajerosTest() {
        List<ViajeroEntity> resultList = viajeroLogic.getViajeros();
        List<ViajeroEntity> expectedList = em.createQuery("SELECT u from ViajeroEntity u").getResultList();
        Assert.assertEquals(expectedList.size(), resultList.size());
        for (ViajeroEntity expected : expectedList) {
            boolean found = false;
            for (ViajeroEntity result : resultList) {
                if (result.getId().equals(expected.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void deleteViajeroTest() {
        ViajeroEntity entity = data.get(1);
        viajeroLogic.deleteViajero(entity.getId());
        ViajeroEntity expected = em.find(ViajeroEntity.class, entity.getId());
        Assert.assertNull(expected);
    }

    @Test
    public void updateViajeroTest() {
        ViajeroEntity entity = data.get(0);
        ViajeroEntity expected = factory.manufacturePojo(ViajeroEntity.class);

        expected.setId(entity.getId());

        viajeroLogic.updateViajero(expected);

        ViajeroEntity resp = em.find(ViajeroEntity.class, entity.getId());

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), resp.getId());
        Assert.assertEquals(expected.getName(), resp.getName());
        Assert.assertEquals(expected.getBirthDate(), resp.getBirthDate());
    }
//      CREAR LOS METODOS DEL LOGIC
//    @Test
//    public void getItinerarioTest() {
//        ViajeroEntity entity = data.get(0);
//        ItinerarioEntity entidadItinerario = itinerariosData.get(0);
//        ItinerarioEntity response = viajeroLogic.getItinerarioDeViajero(entity.getId(), entidadItinerario.getId());
//
//        ItinerarioEntity expected = getItinerarioDeViajero(entity.getId(), entidadItinerario.getId());
//
//        Assert.assertNotNull(expected);
//        Assert.assertNotNull(response);
//        Assert.assertEquals(expected.getId(), response.getId());
//        Assert.assertEquals(expected.getName(), response.getName());
//        Assert.assertEquals(expected.getDescription(), response.getDescription());
//        Assert.assertEquals(expected.getIsbn(), response.getIsbn());
//        Assert.assertEquals(expected.getImage(), response.getImage());
//    }
//          CHEQUEAR BASE DE DATOS PARA LA CONSULTA
//    private ItinerarioEntity getItinerarioDeViajero(Long viajeroId, Long itinerarioId) {
//        Query q = em.createQuery("Select DISTINCT b from ViajeroEntity a join a.itineraios b where a.id=:viajeroId and b.id = :itinerariosId");
//        q.setParameter("itinerarioId", itinerarioId);
//        q.setParameter("viajeroId", viajeroId);
//
//        return (ItinerarioEntity) q.getSingleResult();
//    }

}
