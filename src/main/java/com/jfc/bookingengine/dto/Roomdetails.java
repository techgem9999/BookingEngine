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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "roomdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomdetails.findAll", query = "SELECT r FROM Roomdetails r")
    , @NamedQuery(name = "Roomdetails.findByRoomDetailsId", query = "SELECT r FROM Roomdetails r WHERE r.roomDetailsId = :roomDetailsId")
    , @NamedQuery(name = "Roomdetails.findBySmooking", query = "SELECT r FROM Roomdetails r WHERE r.smooking = :smooking")
    , @NamedQuery(name = "Roomdetails.findByWiFi", query = "SELECT r FROM Roomdetails r WHERE r.wiFi = :wiFi")
    , @NamedQuery(name = "Roomdetails.findByHairdryer", query = "SELECT r FROM Roomdetails r WHERE r.hairdryer = :hairdryer")
    , @NamedQuery(name = "Roomdetails.findByDescription", query = "SELECT r FROM Roomdetails r WHERE r.description = :description")})
public class Roomdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoomDetailsId")
    private Integer roomDetailsId;
    @Column(name = "Smooking")
    private Boolean smooking;
    @Column(name = "WiFi")
    private Boolean wiFi;
    @Column(name = "Hairdryer")
    private Boolean hairdryer;
    @Size(max = 256)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomDetailsId")
    private Collection<Roomarchive> roomarchiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomDetailsId")
    private Collection<Room> roomCollection;
    @JoinColumn(name = "BedId", referencedColumnName = "BedId")
    @ManyToOne(optional = false)
    private Bed bedId;
    @JoinColumn(name = "RoomTypeId", referencedColumnName = "RoomTypeId")
    @ManyToOne(optional = false)
    private Roomtype roomTypeId;

    public Roomdetails() {
    }

    public Roomdetails(Integer roomDetailsId) {
        this.roomDetailsId = roomDetailsId;
    }

    public Integer getRoomDetailsId() {
        return roomDetailsId;
    }

    public void setRoomDetailsId(Integer roomDetailsId) {
        this.roomDetailsId = roomDetailsId;
    }

    public Boolean getSmooking() {
        return smooking;
    }

    public void setSmooking(Boolean smooking) {
        this.smooking = smooking;
    }

    public Boolean getWiFi() {
        return wiFi;
    }

    public void setWiFi(Boolean wiFi) {
        this.wiFi = wiFi;
    }

    public Boolean getHairdryer() {
        return hairdryer;
    }

    public void setHairdryer(Boolean hairdryer) {
        this.hairdryer = hairdryer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Roomarchive> getRoomarchiveCollection() {
        return roomarchiveCollection;
    }

    public void setRoomarchiveCollection(Collection<Roomarchive> roomarchiveCollection) {
        this.roomarchiveCollection = roomarchiveCollection;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public Bed getBedId() {
        return bedId;
    }

    public void setBedId(Bed bedId) {
        this.bedId = bedId;
    }

    public Roomtype getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Roomtype roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomDetailsId != null ? roomDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomdetails)) {
            return false;
        }
        Roomdetails other = (Roomdetails) object;
        if ((this.roomDetailsId == null && other.roomDetailsId != null) || (this.roomDetailsId != null && !this.roomDetailsId.equals(other.roomDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Roomdetails[ roomDetailsId=" + roomDetailsId + " ]";
    }
    
}
