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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "roomarchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomarchive.findAll", query = "SELECT r FROM Roomarchive r")
    , @NamedQuery(name = "Roomarchive.findByRoomArchiveId", query = "SELECT r FROM Roomarchive r WHERE r.roomArchiveId = :roomArchiveId")
    , @NamedQuery(name = "Roomarchive.findByDateChanged", query = "SELECT r FROM Roomarchive r WHERE r.dateChanged = :dateChanged")
    , @NamedQuery(name = "Roomarchive.findByComment", query = "SELECT r FROM Roomarchive r WHERE r.comment = :comment")})
public class Roomarchive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoomArchiveId")
    private Integer roomArchiveId;
    @Column(name = "DateChanged")
    @Temporal(TemporalType.DATE)
    private Date dateChanged;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "Comment")
    private String comment;
    @JoinColumn(name = "RoomId", referencedColumnName = "RoomId")
    @ManyToOne(optional = false)
    private Room roomId;
    @JoinColumn(name = "RoomDetailsId", referencedColumnName = "RoomDetailsId")
    @ManyToOne(optional = false)
    private Roomdetails roomDetailsId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person updatedBy;

    public Roomarchive() {
    }

    public Roomarchive(Integer roomArchiveId) {
        this.roomArchiveId = roomArchiveId;
    }

    public Roomarchive(Integer roomArchiveId, String comment) {
        this.roomArchiveId = roomArchiveId;
        this.comment = comment;
    }

    public Integer getRoomArchiveId() {
        return roomArchiveId;
    }

    public void setRoomArchiveId(Integer roomArchiveId) {
        this.roomArchiveId = roomArchiveId;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Roomdetails getRoomDetailsId() {
        return roomDetailsId;
    }

    public void setRoomDetailsId(Roomdetails roomDetailsId) {
        this.roomDetailsId = roomDetailsId;
    }

    public Person getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Person updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomArchiveId != null ? roomArchiveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomarchive)) {
            return false;
        }
        Roomarchive other = (Roomarchive) object;
        if ((this.roomArchiveId == null && other.roomArchiveId != null) || (this.roomArchiveId != null && !this.roomArchiveId.equals(other.roomArchiveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.bookingengine.dto.Roomarchive[ roomArchiveId=" + roomArchiveId + " ]";
    }
    
}
