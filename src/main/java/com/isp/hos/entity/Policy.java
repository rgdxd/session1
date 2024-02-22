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
@Table(name = "policy")
@NamedQueries({
    @NamedQuery(name = "Policy.findAll", query = "SELECT p FROM Policy p"),
    @NamedQuery(name = "Policy.findById", query = "SELECT p FROM Policy p WHERE p.id = :id"),
    @NamedQuery(name = "Policy.findByNumber", query = "SELECT p FROM Policy p WHERE p.number = :number"),
    @NamedQuery(name = "Policy.findByEndDate", query = "SELECT p FROM Policy p WHERE p.endDate = :endDate")})
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policyId")
    private Collection<Patient> patientCollection;
    
    public List<Policy> getPolicyList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Policy.class);
        Root<Policy> root = cq.from(Policy.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Policy> userList = query.getResultList();
        return userList;
    }

    public void addPolicy(Policy pol, EntityManager em) {
        em.getTransaction().begin();
        em.persist(pol);
        em.getTransaction().commit();
    }

    public void upDatePolicy(Policy pol, EntityManager em) {
        em.getTransaction().begin();
        Policy p = em.find(Policy.class, pol.getId());
        p.setNumber(pol.getNumber());
        p.setEndDate(pol.getEndDate());
        em.merge(p);
        em.getTransaction().commit();
    }

    public void deletePolicy(Policy pol, EntityManager em) {
        em.getTransaction().begin();
        Policy p = em.find(Policy.class, pol.getId());
        em.remove(p);
        em.getTransaction().commit();
    }

    public Policy() {
    }

    public Policy(Integer id) {
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
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
        if (!(object instanceof Policy)) {
            return false;
        }
        Policy other = (Policy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Policy[ id=" + id + " ]";
    }
    
}
