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
@Table(name = "medcard_diseases")
@NamedQueries({
    @NamedQuery(name = "MedcardDiseases.findAll", query = "SELECT m FROM MedcardDiseases m"),
    @NamedQuery(name = "MedcardDiseases.findById", query = "SELECT m FROM MedcardDiseases m WHERE m.id = :id")})
public class MedcardDiseases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "diseases_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diseases diseasesId;
    @JoinColumn(name = "medcard_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medcard medcardId;
    
    public List<MedcardDiseases> getMedcardDiseasesList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(MedcardDiseases.class);
        Root<MedcardDiseases> root = cq.from(MedcardDiseases.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<MedcardDiseases> userList = query.getResultList();
        return userList;
    }
    
    public void addMedcardDiseases(MedcardDiseases md, EntityManager em) {
        em.getTransaction().begin();
        em.persist(md);
        em.getTransaction().commit();
    }

    public MedcardDiseases() {
    }

    public MedcardDiseases(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Diseases getDiseasesId() {
        return diseasesId;
    }

    public void setDiseasesId(Diseases diseasesId) {
        this.diseasesId = diseasesId;
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
        if (!(object instanceof MedcardDiseases)) {
            return false;
        }
        MedcardDiseases other = (MedcardDiseases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.MedcardDiseases[ id=" + id + " ]";
    }
    
}
