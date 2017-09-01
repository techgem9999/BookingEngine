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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByRoomId", query = "SELECT r FROM Room r WHERE r.roomId = :roomId")
    , @NamedQuery(name = "Room.findByRoomNumber", query = "SELECT r FROM Room r WHERE r.roomNumber = :roomNumber")
    , @NamedQuery(name = "Room.findByRoomFloor", query = "SELECT r FROM Room r WHERE r.roomFloor = :roomFloor")
    , @NamedQuery(name = "Room.findByDateFromOccupied", query = "SELECT r FROM Room r WHERE r.dateFromOccupied = :dateFromOccupied")
    , @NamedQuery(name = "Room.findByDateToOccupied", query = "SELECT r FROM Room r WHERE r.dateToOccupied = :dateToOccupied")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoomId")
    private Integer roomId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoomNumber")
    private int roomNumber;
    @Column(name = "RoomFloor")
    private Boolean roomFloor;
    @Column(name = "DateFromOccupied")
    private Boolean dateFromOccupied;
    @Column(name = "DateToOccupied")
    private Boolean dateToOccupied;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<Roomarchive> roomarchiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<Bookingdetails> bookingdetailsCollection;
    @JoinColumn(name = "HotelId", referencedColumnName = "HotelId")
    @ManyToOne(optional = false)
    private Hotel hotelId;
    @JoinColumn(name = "RoomDetailsId", referencedColumnName = "RoomDetailsId")
    @ManyToOne(optional = false)
    private Roomdetails roomDetailsId;

    public Room() {
    }

    public Room(Integer roomId) {
        this.roomId = roomId;
    }

    public Room(Integer roomId, int roomNumber) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Boolean roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Boolean getDateFromOccupied() {
        return dateFromOccupied;
    }

    public void setDateFromOccupied(Boolean dateFromOccupied) {
        this.dateFromOccupied = dateFromOccupied;
    }

    public Boolean getDateToOccupied() {
        return dateToOccupied;
    }

    public void setDateToOccupied(Boolean dateToOccupied) {
        this.dateToOccupied = dateToOccupied;
    }

    @XmlTransient
    public Collection<Roomarchive> getRoomarchiveCollection() {
        return roomarchiveCollection;
    }

    public void setRoomarchiveCollection(Collection<Roomarchive> roomarchiveCollection) {
        this.roomarchiveCollection = roomarchiveCollection;
    }

    @XmlTransient
    public Collection<Bookingdetails> getBookingdetailsCollection() {
        return bookingdetailsCollection;
    }

    public void setBookingdetailsCollection(Collection<Bookingdetails> bookingdetailsCollection) {
        this.bookingdetailsCollection = bookingdetailsCollection;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public Roomdetails getRoomDetailsId() {
        return roomDetailsId;
    }

    public void setRoomDetailsId(Roomdetails roomDetailsId) {
        this.roomDetailsId = roomDetailsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Room[ roomId=" + roomId + " ]";
    }
    
}
