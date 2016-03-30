/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.api;
import co.edu.uniandes.csw.primid.logic.entities.TimelineEntity;
import java.util.List;

/**
 *
 * @author s.gonzalez22
 */
public interface ITimelineLogic {

     public List<TimelineEntity> getTimelines();

}
