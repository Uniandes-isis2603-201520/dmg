/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.ejbs;

import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.primid.logic.api.IPlanEventoLogic;
import co.edu.uniandes.csw.primid.logic.entities.PlanEventoEntity;
import co.edu.uniandes.csw.primid.logic.persistence.PlanEventoPersistence;
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
public class PlanEventoLogic implements IPlanEventoLogic {


     private static final Logger logger = Logger.getLogger(PlanEventoLogic.class.getName());

    @Inject
    private PlanEventoPersistence persistence;

    @Inject
    IPlanEventoLogic planEventoLogic;

    


}
