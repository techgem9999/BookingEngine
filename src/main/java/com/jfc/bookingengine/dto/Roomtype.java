/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "roomtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r")
    , @NamedQuery(name = "Roomtype.findByRoomTypeId", query = "SELECT r FROM Roomtype r WHERE r.roomTypeId = :roomTypeId")
    , @NamedQuery(name = "Roomtype.findByType", query = "SELECT r FROM Roomtype r WHERE r.type = :type")
    , @NamedQuery(name = "Roomtype.findByPrice", query = "SELECT r FROM Roomtype r WHERE r.price = :price")
    , @NamedQuery(name = "Roomtype.findByMaxAdultCapacity", query = "SELECT r FROM Roomtype r WHERE r.maxAdultCapacity = :maxAdultCapacity")
    , @NamedQuery(name = "Roomtype.findByMaxChildCapacity", query = "SELECT r FROM Roomtype r WHERE r.maxChildCapacity = :maxChildCapacity")})
public class Roomtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoomTypeId")
    private Integer roomTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Column(name = "MaxAdultCapacity")
    private Short maxAdultCapacity;
    @Column(name = "MaxChildCapacity")
    private Short maxChildCapacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomTypeId")
    private Collection<Roomdetails> roomdetailsCollection;

    public Roomtype() {
    }

    public Roomtype(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Roomtype(Integer roomTypeId, String type, float price) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.price = price;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Short getMaxAdultCapacity() {
        return maxAdultCapacity;
    }

    public void setMaxAdultCapacity(Short maxAdultCapacity) {
        this.maxAdultCapacity = maxAdultCapacity;
    }

    public Short getMaxChildCapacity() {
        return maxChildCapacity;
    }

    public void setMaxChildCapacity(Short maxChildCapacity) {
        this.maxChildCapacity = maxChildCapacity;
    }

    @XmlTransient
    public Collection<Roomdetails> getRoomdetailsCollection() {
        return roomdetailsCollection;
    }

    public void setRoomdetailsCollection(Collection<Roomdetails> roomdetailsCollection) {
        this.roomdetailsCollection = roomdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomTypeId != null ? roomTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.roomTypeId == null && other.roomTypeId != null) || (this.roomTypeId != null && !this.roomTypeId.equals(other.roomTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Roomtype[ roomTypeId=" + roomTypeId + " ]";
    }
    
}
