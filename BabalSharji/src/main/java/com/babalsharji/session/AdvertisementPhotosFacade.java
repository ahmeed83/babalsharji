/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.babalsharji.session;

import com.babalsharji.entity.AdvertisementPhotos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tsl20897
 */
@Stateless
public class AdvertisementPhotosFacade extends AbstractFacade<AdvertisementPhotos> {
    @PersistenceContext(unitName = "com.babalsharji_BabalSharji_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvertisementPhotosFacade() {
        super(AdvertisementPhotos.class);
    }
    
}
