/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.primid.logic.api;

import co.edu.uniandes.csw.primid.logic.entities.MultimediaEntity;
import co.edu.uniandes.csw.primid.logic.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author fa.lopez10
 */
public interface IMultimediaLogic {

    public List<MultimediaEntity> getMultimedia();

    public MultimediaEntity getArchivoMultimedia(Long id);

    public MultimediaEntity createArchivoMultimedia(MultimediaEntity entity);

    public MultimediaEntity updateArchivoMultimedia(MultimediaEntity entity);

    public void deleteArchivoMultimedia(Long id);
}
