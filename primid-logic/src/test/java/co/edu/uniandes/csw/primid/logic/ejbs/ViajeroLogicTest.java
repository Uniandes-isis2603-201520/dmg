package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.primid.logic.api.IViajeroLogic;
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

    //private List<BookEntity> booksData = new ArrayList<>();

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
//        for (int i = 0; i < 3; i++) {
//            BookEntity books = factory.manufacturePojo(BookEntity.class);
//            books.setPublishDate(getMaxDate());
//            em.persist(books);
//            booksData.add(books);
//        }
        for (int i = 0; i < 3; i++) {
            ViajeroEntity entity = factory.manufacturePojo(ViajeroEntity.class);

            em.persist(entity);
            data.add(entity);

            //booksData.get(0).getAuthors().add(entity);
        }
    }

      @Test
    public void createAuthorTest() {
        ViajeroEntity expected = factory.manufacturePojo(ViajeroEntity.class);
        ViajeroEntity created = viajeroLogic.createViajero(expected);

        ViajeroEntity result = em.find(ViajeroEntity.class, created.getId());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
        Assert.assertEquals(expected.getBirthDate(), result.getBirthDate());
    }



}