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

@Entity
@Table(name = "advertisemnt_photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvertisemntPhotos.findAll", query = "SELECT a FROM AdvertisemntPhotos a"),
    @NamedQuery(name = "AdvertisemntPhotos.findById", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.id = :id"),
    @NamedQuery(name = "AdvertisemntPhotos.findByName", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.name = :name"),
    @NamedQuery(name = "AdvertisemntPhotos.findByAlt", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.alt = :alt"),
    @NamedQuery(name = "AdvertisemntPhotos.findByPath", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.path = :path"),
    @NamedQuery(name = "AdvertisemntPhotos.findBySize", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.size = :size"),
    @NamedQuery(name = "AdvertisemntPhotos.findByAdvertismentId", query = "SELECT a FROM AdvertisemntPhotos a WHERE a.advertismentId = :advertismentId")})
public class AdvertisemntPhotos implements Serializable {
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

    public AdvertisemntPhotos() {
    }

    public AdvertisemntPhotos(Integer id) {
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
        if (!(object instanceof AdvertisemntPhotos)) {
            return false;
        }
        AdvertisemntPhotos other = (AdvertisemntPhotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.babalsharji.entity.AdvertisemntPhotos[ id=" + id + " ]";
    }
    
}
