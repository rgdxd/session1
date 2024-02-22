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
@Table(name = "medcard")
@NamedQueries({
    @NamedQuery(name = "Medcard.findAll", query = "SELECT m FROM Medcard m"),
    @NamedQuery(name = "Medcard.findById", query = "SELECT m FROM Medcard m WHERE m.id = :id"),
    @NamedQuery(name = "Medcard.findByNumber", query = "SELECT m FROM Medcard m WHERE m.number = :number"),
    @NamedQuery(name = "Medcard.findByDateOfIssue", query = "SELECT m FROM Medcard m WHERE m.dateOfIssue = :dateOfIssue"),
    @NamedQuery(name = "Medcard.findByDateOfLastRequest", query = "SELECT m FROM Medcard m WHERE m.dateOfLastRequest = :dateOfLastRequest"),
    @NamedQuery(name = "Medcard.findByDateOfTheNextVisit", query = "SELECT m FROM Medcard m WHERE m.dateOfTheNextVisit = :dateOfTheNextVisit"),
    @NamedQuery(name = "Medcard.findByAnamnesis", query = "SELECT m FROM Medcard m WHERE m.anamnesis = :anamnesis"),
    @NamedQuery(name = "Medcard.findByRecommendations", query = "SELECT m FROM Medcard m WHERE m.recommendations = :recommendations")})
public class Medcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "date_of_issue")
    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;
    @Column(name = "date_of_last_request")
    @Temporal(TemporalType.DATE)
    private Date dateOfLastRequest;
    @Column(name = "date_of_the_next_visit")
    @Temporal(TemporalType.DATE)
    private Date dateOfTheNextVisit;
    @Column(name = "anamnesis")
    private String anamnesis;
    @Column(name = "recommendations")
    private String recommendations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medcardId")
    private Collection<MedcardDiseases> medcardDiseasesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medcardId")
    private Collection<PatientMeasures> patientMeasuresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medcardId")
    private Collection<Patient> patientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medcardId")
    private Collection<RecipeMedcard> recipeMedcardCollection;
    
    public List<Medcard> getMedcardList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Medcard.class);
        Root<Medcard> root = cq.from(Medcard.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Medcard> userList = query.getResultList();
        return userList;
    }

    public void addMedcard(Medcard mcard, EntityManager em) {
        em.getTransaction().begin();
        em.persist(mcard);
        em.getTransaction().commit();
    }

    public void upDateMedcard(Medcard mcard, EntityManager em) {
        em.getTransaction().begin();
        Medcard m = em.find(Medcard.class, mcard.getId());
        m.setNumber(mcard.getNumber());
        m.setDateOfIssue(mcard.getDateOfIssue());
        m.setDateOfLastRequest(mcard.getDateOfLastRequest());
        m.setDateOfTheNextVisit(mcard.getDateOfTheNextVisit());
        em.merge(m);
        em.getTransaction().commit();
    }

    public void deleteMedcard(Medcard mcard, EntityManager em) {
        em.getTransaction().begin();
        Medcard m = em.find(Medcard.class, mcard.getId());
        em.remove(m);
        em.getTransaction().commit();
    }

    public Medcard() {
    }

    public Medcard(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfLastRequest() {
        return dateOfLastRequest;
    }

    public void setDateOfLastRequest(Date dateOfLastRequest) {
        this.dateOfLastRequest = dateOfLastRequest;
    }

    public Date getDateOfTheNextVisit() {
        return dateOfTheNextVisit;
    }

    public void setDateOfTheNextVisit(Date dateOfTheNextVisit) {
        this.dateOfTheNextVisit = dateOfTheNextVisit;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Collection<MedcardDiseases> getMedcardDiseasesCollection() {
        return medcardDiseasesCollection;
    }

    public void setMedcardDiseasesCollection(Collection<MedcardDiseases> medcardDiseasesCollection) {
        this.medcardDiseasesCollection = medcardDiseasesCollection;
    }

    public Collection<PatientMeasures> getPatientMeasuresCollection() {
        return patientMeasuresCollection;
    }

    public void setPatientMeasuresCollection(Collection<PatientMeasures> patientMeasuresCollection) {
        this.patientMeasuresCollection = patientMeasuresCollection;
    }

    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    public Collection<RecipeMedcard> getRecipeMedcardCollection() {
        return recipeMedcardCollection;
    }

    public void setRecipeMedcardCollection(Collection<RecipeMedcard> recipeMedcardCollection) {
        this.recipeMedcardCollection = recipeMedcardCollection;
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
        if (!(object instanceof Medcard)) {
            return false;
        }
        Medcard other = (Medcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Medcard[ id=" + id + " ]";
    }
    
}
