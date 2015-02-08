package com.babalsharji.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "advertisements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisements.findAll", query = "SELECT a FROM Advertisements a"),
    @NamedQuery(name = "Advertisements.findById", query = "SELECT a FROM Advertisements a WHERE a.id = :id"),
    @NamedQuery(name = "Advertisements.findByName", query = "SELECT a FROM Advertisements a WHERE a.name = :name"),
    @NamedQuery(name = "Advertisements.findByPrice", query = "SELECT a FROM Advertisements a WHERE a.price = :price")})
public class Advertisements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "price")
    private String price;

    public Advertisements() {
    }

    public Advertisements(Integer id) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        if (!(object instanceof Advertisements)) {
            return false;
        }
        Advertisements other = (Advertisements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.babalsharji.entity.Advertisements[ id=" + id + " ]";
    }
    
}
