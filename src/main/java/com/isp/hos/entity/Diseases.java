/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isp.hos.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "diseases")
@NamedQueries({
    @NamedQuery(name = "Diseases.findAll", query = "SELECT d FROM Diseases d"),
    @NamedQuery(name = "Diseases.findById", query = "SELECT d FROM Diseases d WHERE d.id = :id"),
    @NamedQuery(name = "Diseases.findByDisease", query = "SELECT d FROM Diseases d WHERE d.disease = :disease")})
public class Diseases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "disease")
    private String disease;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diseasesId")
    private Collection<MedcardDiseases> medcardDiseasesCollection;
    
    public List<Diseases> getDiseasesList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Diseases.class);
        Root<Diseases> root = cq.from(Diseases.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Diseases> userList = query.getResultList();
        return userList;
    }

    public Diseases() {
    }

    public Diseases(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Collection<MedcardDiseases> getMedcardDiseasesCollection() {
        return medcardDiseasesCollection;
    }

    public void setMedcardDiseasesCollection(Collection<MedcardDiseases> medcardDiseasesCollection) {
        this.medcardDiseasesCollection = medcardDiseasesCollection;
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
        if (!(object instanceof Diseases)) {
            return false;
        }
        Diseases other = (Diseases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Diseases[ id=" + id + " ]";
    }
    
}
