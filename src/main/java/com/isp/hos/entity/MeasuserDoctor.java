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
@Table(name = "measuser_doctor")
@NamedQueries({
    @NamedQuery(name = "MeasuserDoctor.findAll", query = "SELECT m FROM MeasuserDoctor m"),
    @NamedQuery(name = "MeasuserDoctor.findById", query = "SELECT m FROM MeasuserDoctor m WHERE m.id = :id")})
public class MeasuserDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "measuser_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DiagnosticMeasures measuserId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Doctor doctorId;

    public MeasuserDoctor() {
    }

    public MeasuserDoctor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiagnosticMeasures getMeasuserId() {
        return measuserId;
    }

    public void setMeasuserId(DiagnosticMeasures measuserId) {
        this.measuserId = measuserId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
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
        if (!(object instanceof MeasuserDoctor)) {
            return false;
        }
        MeasuserDoctor other = (MeasuserDoctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.MeasuserDoctor[ id=" + id + " ]";
    }
    
}
