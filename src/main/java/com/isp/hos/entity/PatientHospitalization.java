/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isp.hos.entity;

import java.io.Serializable;
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

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "patient_hospitalization")
@NamedQueries({
    @NamedQuery(name = "PatientHospitalization.findAll", query = "SELECT p FROM PatientHospitalization p"),
    @NamedQuery(name = "PatientHospitalization.findById", query = "SELECT p FROM PatientHospitalization p WHERE p.id = :id")})
public class PatientHospitalization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "hospitalization_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hospitalization hospitalizationId;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public PatientHospitalization() {
    }

    public PatientHospitalization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospitalization getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Hospitalization hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
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
        if (!(object instanceof PatientHospitalization)) {
            return false;
        }
        PatientHospitalization other = (PatientHospitalization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.PatientHospitalization[ id=" + id + " ]";
    }
    
}
