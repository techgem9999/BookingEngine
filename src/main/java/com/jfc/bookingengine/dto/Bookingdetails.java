/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "bookingdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookingdetails.findAll", query = "SELECT b FROM Bookingdetails b")
    , @NamedQuery(name = "Bookingdetails.findByBookingDetailsId", query = "SELECT b FROM Bookingdetails b WHERE b.bookingDetailsId = :bookingDetailsId")
    , @NamedQuery(name = "Bookingdetails.findByCheckIn", query = "SELECT b FROM Bookingdetails b WHERE b.checkIn = :checkIn")
    , @NamedQuery(name = "Bookingdetails.findByCheckOut", query = "SELECT b FROM Bookingdetails b WHERE b.checkOut = :checkOut")
    , @NamedQuery(name = "Bookingdetails.findByCheckedIn", query = "SELECT b FROM Bookingdetails b WHERE b.checkedIn = :checkedIn")
    , @NamedQuery(name = "Bookingdetails.findByCheckedOut", query = "SELECT b FROM Bookingdetails b WHERE b.checkedOut = :checkedOut")
    , @NamedQuery(name = "Bookingdetails.findByCanceled", query = "SELECT b FROM Bookingdetails b WHERE b.canceled = :canceled")})
public class Bookingdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingDetailsId")
    private Integer bookingDetailsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CheckIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CheckOut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CheckedIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CheckedOut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedOut;
    @Column(name = "Canceled")
    private Boolean canceled;
    @JoinColumn(name = "BookingId", referencedColumnName = "BookingId")
    @ManyToOne(optional = false)
    private Booking bookingId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "RoomId", referencedColumnName = "RoomId")
    @ManyToOne(optional = false)
    private Room roomId;

    public Bookingdetails() {
    }

    public Bookingdetails(Integer bookingDetailsId) {
        this.bookingDetailsId = bookingDetailsId;
    }

    public Bookingdetails(Integer bookingDetailsId, Date checkIn, Date checkOut, Date checkedIn, Date checkedOut) {
        this.bookingDetailsId = bookingDetailsId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.checkedIn = checkedIn;
        this.checkedOut = checkedOut;
    }

    public Integer getBookingDetailsId() {
        return bookingDetailsId;
    }

    public void setBookingDetailsId(Integer bookingDetailsId) {
        this.bookingDetailsId = bookingDetailsId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Date checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Date getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Date checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingDetailsId != null ? bookingDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingdetails)) {
            return false;
        }
        Bookingdetails other = (Bookingdetails) object;
        if ((this.bookingDetailsId == null && other.bookingDetailsId != null) || (this.bookingDetailsId != null && !this.bookingDetailsId.equals(other.bookingDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Bookingdetails[ bookingDetailsId=" + bookingDetailsId + " ]";
    }
    
}
