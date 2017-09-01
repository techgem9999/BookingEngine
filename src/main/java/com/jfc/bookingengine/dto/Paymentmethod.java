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
@Table(name = "paymentmethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentmethod.findAll", query = "SELECT p FROM Paymentmethod p")
    , @NamedQuery(name = "Paymentmethod.findByPaymentMethodId", query = "SELECT p FROM Paymentmethod p WHERE p.paymentMethodId = :paymentMethodId")
    , @NamedQuery(name = "Paymentmethod.findByPaymentMethod", query = "SELECT p FROM Paymentmethod p WHERE p.paymentMethod = :paymentMethod")})
public class Paymentmethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentMethodId")
    private Integer paymentMethodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethodId")
    private Collection<Paymentdetails> paymentdetailsCollection;

    public Paymentmethod() {
    }

    public Paymentmethod(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Paymentmethod(Integer paymentMethodId, String paymentMethod) {
        this.paymentMethodId = paymentMethodId;
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @XmlTransient
    public Collection<Paymentdetails> getPaymentdetailsCollection() {
        return paymentdetailsCollection;
    }

    public void setPaymentdetailsCollection(Collection<Paymentdetails> paymentdetailsCollection) {
        this.paymentdetailsCollection = paymentdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentmethod)) {
            return false;
        }
        Paymentmethod other = (Paymentmethod) object;
        if ((this.paymentMethodId == null && other.paymentMethodId != null) || (this.paymentMethodId != null && !this.paymentMethodId.equals(other.paymentMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Paymentmethod[ paymentMethodId=" + paymentMethodId + " ]";
    }
    
}
