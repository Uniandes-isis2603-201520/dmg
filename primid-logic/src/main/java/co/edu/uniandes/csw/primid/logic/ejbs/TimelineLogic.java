/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;
import co.edu.uniandes.csw.primid.logic.api.ITimelineLogic;
import co.edu.uniandes.csw.primid.logic.entities.TimelineEntity;
import co.edu.uniandes.csw.primid.logic.persistence.TimelinePersistence;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.gonzalez22
 */
@Stateless
public class TimelineLogic implements ITimelineLogic {

    private static final Logger logger = Logger.getLogger(TimelineLogic.class.getName());

    @Inject
    private TimelinePersistence persistence;



    @Override
    public List<TimelineEntity> getTimelines() {
        logger.info("Inicia proceso de consultar todos los timelines");
        logger.info("Termina proceso de consultar todos los timelines");
        return null;
    }


}
