package com.babalsharji.session;

import com.babalsharji.entity.AdvertisemntPhotos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdvertisemntPhotosFacade extends AbstractFacade<AdvertisemntPhotos> {
    @PersistenceContext(unitName = "com.babalsharji_BabalSharji_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvertisemntPhotosFacade() {
        super(AdvertisemntPhotos.class);
    }
    
}
