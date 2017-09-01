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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "paymentdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentdetails.findAll", query = "SELECT p FROM Paymentdetails p")
    , @NamedQuery(name = "Paymentdetails.findByPaymentDetailsId", query = "SELECT p FROM Paymentdetails p WHERE p.paymentDetailsId = :paymentDetailsId")
    , @NamedQuery(name = "Paymentdetails.findByAmount", query = "SELECT p FROM Paymentdetails p WHERE p.amount = :amount")
    , @NamedQuery(name = "Paymentdetails.findByComment", query = "SELECT p FROM Paymentdetails p WHERE p.comment = :comment")})
public class Paymentdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentDetailsId")
    private Integer paymentDetailsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private float amount;
    @Size(max = 200)
    @Column(name = "Comment")
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentDetailsId")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "PaymentMethodId", referencedColumnName = "PaymentMethodId")
    @ManyToOne(optional = false)
    private Paymentmethod paymentMethodId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;

    public Paymentdetails() {
    }

    public Paymentdetails(Integer paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public Paymentdetails(Integer paymentDetailsId, float amount) {
        this.paymentDetailsId = paymentDetailsId;
        this.amount = amount;
    }

    public Integer getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Integer paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Paymentmethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Paymentmethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDetailsId != null ? paymentDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentdetails)) {
            return false;
        }
        Paymentdetails other = (Paymentdetails) object;
        if ((this.paymentDetailsId == null && other.paymentDetailsId != null) || (this.paymentDetailsId != null && !this.paymentDetailsId.equals(other.paymentDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Paymentdetails[ paymentDetailsId=" + paymentDetailsId + " ]";
    }
    
}
