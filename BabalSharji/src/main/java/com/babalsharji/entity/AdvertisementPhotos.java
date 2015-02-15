/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.babalsharji.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tsl20897
 */
@Entity
@Table(name = "advertisement_photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvertisementPhotos.findAll", query = "SELECT a FROM AdvertisementPhotos a"),
    @NamedQuery(name = "AdvertisementPhotos.findById", query = "SELECT a FROM AdvertisementPhotos a WHERE a.id = :id"),
    @NamedQuery(name = "AdvertisementPhotos.findByName", query = "SELECT a FROM AdvertisementPhotos a WHERE a.name = :name"),
    @NamedQuery(name = "AdvertisementPhotos.findByAlt", query = "SELECT a FROM AdvertisementPhotos a WHERE a.alt = :alt"),
    @NamedQuery(name = "AdvertisementPhotos.findByPath", query = "SELECT a FROM AdvertisementPhotos a WHERE a.path = :path"),
    @NamedQuery(name = "AdvertisementPhotos.findBySize", query = "SELECT a FROM AdvertisementPhotos a WHERE a.size = :size"),
    @NamedQuery(name = "AdvertisementPhotos.findByAdvertismentId", query = "SELECT a FROM AdvertisementPhotos a WHERE a.advertismentId = :advertismentId")})
public class AdvertisementPhotos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "alt")
    private String alt;
    @Size(max = 45)
    @Column(name = "path")
    private String path;
    @Size(max = 45)
    @Column(name = "size")
    private String size;
    @Column(name = "advertisment_id")
    private Integer advertismentId;

    public AdvertisementPhotos() {
    }

    public AdvertisementPhotos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getAdvertismentId() {
        return advertismentId;
    }

    public void setAdvertismentId(Integer advertismentId) {
        this.advertismentId = advertismentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdvertisementPhotos)) {
            return false;
        }
        AdvertisementPhotos other = (AdvertisementPhotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.babalsharji.entity.AdvertisementPhotos[ id=" + id + " ]";
    }
    
}
