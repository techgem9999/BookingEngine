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
@Table(name = "bed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bed.findAll", query = "SELECT b FROM Bed b")
    , @NamedQuery(name = "Bed.findByBedId", query = "SELECT b FROM Bed b WHERE b.bedId = :bedId")
    , @NamedQuery(name = "Bed.findByBedName", query = "SELECT b FROM Bed b WHERE b.bedName = :bedName")})
public class Bed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BedId")
    private Integer bedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "BedName")
    private String bedName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bedId")
    private Collection<Roomdetails> roomdetailsCollection;

    public Bed() {
    }

    public Bed(Integer bedId) {
        this.bedId = bedId;
    }

    public Bed(Integer bedId, String bedName) {
        this.bedId = bedId;
        this.bedName = bedName;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
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
        hash += (bedId != null ? bedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bed)) {
            return false;
        }
        Bed other = (Bed) object;
        if ((this.bedId == null && other.bedId != null) || (this.bedId != null && !this.bedId.equals(other.bedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Bed[ bedId=" + bedId + " ]";
    }
    
}
