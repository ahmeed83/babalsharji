package com.babalsharji.session;

import com.babalsharji.entity.AdvertisementPhotos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
