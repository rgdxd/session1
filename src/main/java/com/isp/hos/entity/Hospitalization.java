/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isp.hos.entity;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "hospitalization")
@NamedQueries({
    @NamedQuery(name = "Hospitalization.findAll", query = "SELECT h FROM Hospitalization h"),
    @NamedQuery(name = "Hospitalization.findById", query = "SELECT h FROM Hospitalization h WHERE h.id = :id"),
    @NamedQuery(name = "Hospitalization.findByDate", query = "SELECT h FROM Hospitalization h WHERE h.date = :date"),
    @NamedQuery(name = "Hospitalization.findByReason", query = "SELECT h FROM Hospitalization h WHERE h.reason = :reason")})
public class Hospitalization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "reason")
    private String reason;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalizationId")
    private Collection<PatientHospitalization> patientHospitalizationCollection;

    public Hospitalization() {
    }

    public Hospitalization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Collection<PatientHospitalization> getPatientHospitalizationCollection() {
        return patientHospitalizationCollection;
    }

    public void setPatientHospitalizationCollection(Collection<PatientHospitalization> patientHospitalizationCollection) {
        this.patientHospitalizationCollection = patientHospitalizationCollection;
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
        if (!(object instanceof Hospitalization)) {
            return false;
        }
        Hospitalization other = (Hospitalization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Hospitalization[ id=" + id + " ]";
    }
    
}
