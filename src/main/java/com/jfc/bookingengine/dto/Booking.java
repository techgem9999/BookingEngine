/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByTotalPrice", query = "SELECT b FROM Booking b WHERE b.totalPrice = :totalPrice")
    , @NamedQuery(name = "Booking.findByComment", query = "SELECT b FROM Booking b WHERE b.comment = :comment")
    , @NamedQuery(name = "Booking.findByDateBooked", query = "SELECT b FROM Booking b WHERE b.dateBooked = :dateBooked")
    , @NamedQuery(name = "Booking.findByTimeBooked", query = "SELECT b FROM Booking b WHERE b.timeBooked = :timeBooked")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingId")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice")
    private float totalPrice;
    @Size(max = 200)
    @Column(name = "Comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateBooked")
    @Temporal(TemporalType.DATE)
    private Date dateBooked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeBooked")
    @Temporal(TemporalType.TIME)
    private Date timeBooked;
    @JoinColumn(name = "PaymentDetailsId", referencedColumnName = "PaymentDetailsId")
    @ManyToOne(optional = false)
    private Paymentdetails paymentDetailsId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private Collection<Bookingdetails> bookingdetailsCollection;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, float totalPrice, Date dateBooked, Date timeBooked) {
        this.bookingId = bookingId;
        this.totalPrice = totalPrice;
        this.dateBooked = dateBooked;
        this.timeBooked = timeBooked;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Date getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(Date timeBooked) {
        this.timeBooked = timeBooked;
    }

    public Paymentdetails getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Paymentdetails paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Bookingdetails> getBookingdetailsCollection() {
        return bookingdetailsCollection;
    }

    public void setBookingdetailsCollection(Collection<Bookingdetails> bookingdetailsCollection) {
        this.bookingdetailsCollection = bookingdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
