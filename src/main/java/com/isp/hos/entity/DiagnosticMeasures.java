/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isp.hos.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "diagnostic_measures")
@NamedQueries({
    @NamedQuery(name = "DiagnosticMeasures.findAll", query = "SELECT d FROM DiagnosticMeasures d"),
    @NamedQuery(name = "DiagnosticMeasures.findById", query = "SELECT d FROM DiagnosticMeasures d WHERE d.id = :id"),
    @NamedQuery(name = "DiagnosticMeasures.findByDate", query = "SELECT d FROM DiagnosticMeasures d WHERE d.date = :date"),
    @NamedQuery(name = "DiagnosticMeasures.findByType", query = "SELECT d FROM DiagnosticMeasures d WHERE d.type = :type"),
    @NamedQuery(name = "DiagnosticMeasures.findByTitle", query = "SELECT d FROM DiagnosticMeasures d WHERE d.title = :title"),
    @NamedQuery(name = "DiagnosticMeasures.findByRecommendations", query = "SELECT d FROM DiagnosticMeasures d WHERE d.recommendations = :recommendations")})
public class DiagnosticMeasures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "type")
    private String type;
    @Column(name = "title")
    private String title;
    @Column(name = "recommendations")
    private String recommendations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measuserId")
    private Collection<MeasuserDoctor> measuserDoctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measuresId")
    private Collection<PatientMeasures> patientMeasuresCollection;
    
    public List<DiagnosticMeasures> getDiagnosticMeasuresList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(DiagnosticMeasures.class);
        Root<DiagnosticMeasures> root = cq.from(DiagnosticMeasures.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<DiagnosticMeasures> userList = query.getResultList();
        return userList;
    }

    public DiagnosticMeasures() {
    }

    public DiagnosticMeasures(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Collection<MeasuserDoctor> getMeasuserDoctorCollection() {
        return measuserDoctorCollection;
    }

    public void setMeasuserDoctorCollection(Collection<MeasuserDoctor> measuserDoctorCollection) {
        this.measuserDoctorCollection = measuserDoctorCollection;
    }

    public Collection<PatientMeasures> getPatientMeasuresCollection() {
        return patientMeasuresCollection;
    }

    public void setPatientMeasuresCollection(Collection<PatientMeasures> patientMeasuresCollection) {
        this.patientMeasuresCollection = patientMeasuresCollection;
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
        if (!(object instanceof DiagnosticMeasures)) {
            return false;
        }
        DiagnosticMeasures other = (DiagnosticMeasures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.DiagnosticMeasures[ id=" + id + " ]";
    }
    
}
