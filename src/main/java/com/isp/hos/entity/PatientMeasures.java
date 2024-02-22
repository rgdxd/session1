/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isp.hos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "patient_measures")
@NamedQueries({
    @NamedQuery(name = "PatientMeasures.findAll", query = "SELECT p FROM PatientMeasures p"),
    @NamedQuery(name = "PatientMeasures.findById", query = "SELECT p FROM PatientMeasures p WHERE p.id = :id")})
public class PatientMeasures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "measures_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DiagnosticMeasures measuresId;
    @JoinColumn(name = "medcard_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medcard medcardId;
    
    public List<PatientMeasures> getPatientMeasuresList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(PatientMeasures.class);
        Root<PatientMeasures> root = cq.from(PatientMeasures.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<PatientMeasures> userList = query.getResultList();
        return userList;
    }

    public void addPatientMeasures(PatientMeasures pm, EntityManager em) {
        em.getTransaction().begin();
        em.persist(pm);
        em.getTransaction().commit();
    }

    public PatientMeasures() {
    }

    public PatientMeasures(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiagnosticMeasures getMeasuresId() {
        return measuresId;
    }

    public void setMeasuresId(DiagnosticMeasures measuresId) {
        this.measuresId = measuresId;
    }

    public Medcard getMedcardId() {
        return medcardId;
    }

    public void setMedcardId(Medcard medcardId) {
        this.medcardId = medcardId;
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
        if (!(object instanceof PatientMeasures)) {
            return false;
        }
        PatientMeasures other = (PatientMeasures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.PatientMeasures[ id=" + id + " ]";
    }
    
}
