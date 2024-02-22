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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "patient")
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
    @NamedQuery(name = "Patient.findByPhoto", query = "SELECT p FROM Patient p WHERE p.photo = :photo"),
    @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name"),
    @NamedQuery(name = "Patient.findBySurname", query = "SELECT p FROM Patient p WHERE p.surname = :surname"),
    @NamedQuery(name = "Patient.findByPatronymic", query = "SELECT p FROM Patient p WHERE p.patronymic = :patronymic"),
    @NamedQuery(name = "Patient.findByPassportNumber", query = "SELECT p FROM Patient p WHERE p.passportNumber = :passportNumber"),
    @NamedQuery(name = "Patient.findByPassportSeries", query = "SELECT p FROM Patient p WHERE p.passportSeries = :passportSeries"),
    @NamedQuery(name = "Patient.findByDateOfBith", query = "SELECT p FROM Patient p WHERE p.dateOfBith = :dateOfBith"),
    @NamedQuery(name = "Patient.findByGender", query = "SELECT p FROM Patient p WHERE p.gender = :gender"),
    @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address"),
    @NamedQuery(name = "Patient.findByPhonenumber", query = "SELECT p FROM Patient p WHERE p.phonenumber = :phonenumber"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "photo")
    private String photo;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "passport_number")
    private Integer passportNumber;
    @Column(name = "passport_series")
    private Integer passportSeries;
    @Column(name = "date_of_bith")
    @Temporal(TemporalType.DATE)
    private Date dateOfBith;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<PatientHospitalization> patientHospitalizationCollection;
    @JoinColumn(name = "medcard_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medcard medcardId;
    @JoinColumn(name = "policy_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Policy policyId;
    
    public List<Patient> getPatientList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Patient.class);
        Root<Patient> root = cq.from(Patient.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Patient> userList = query.getResultList();
        return userList;
    }
    
    public void addPatient(Patient pat, EntityManager em) {
        em.getTransaction().begin();
        em.persist(pat);
        em.getTransaction().commit();
    }
    
     public void upDatePatient(Patient pat, EntityManager em) {
        em.getTransaction().begin();
        Patient p = em.find(Patient.class, pat.getId());
        p.setName(pat.getName());
        p.setSurname(pat.getSurname());
        p.setPatronymic(pat.getPatronymic());
        p.setPassportNumber(pat.getPassportNumber());
        p.setPassportSeries(pat.getPassportSeries());
        p.setDateOfBith(pat.getDateOfBith());
        p.setGender(pat.getGender());
        p.setAddress(pat.getAddress());
        p.setPhonenumber(pat.getPhonenumber());
        p.setEmail(pat.getEmail());
        p.setMedcardId(pat.getMedcardId());
        p.setPolicyId(pat.getPolicyId());
        em.merge(p);
        em.getTransaction().commit();
    }
     
     public void deletePatient(Patient pat, EntityManager em) {
        em.getTransaction().begin();
        Patient p = em.find(Patient.class, pat.getId());
        em.remove(p);
        em.getTransaction().commit();
    }

    public Patient() {
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Integer getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(Integer passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Date getDateOfBith() {
        return dateOfBith;
    }

    public void setDateOfBith(Date dateOfBith) {
        this.dateOfBith = dateOfBith;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<PatientHospitalization> getPatientHospitalizationCollection() {
        return patientHospitalizationCollection;
    }

    public void setPatientHospitalizationCollection(Collection<PatientHospitalization> patientHospitalizationCollection) {
        this.patientHospitalizationCollection = patientHospitalizationCollection;
    }

    public Medcard getMedcardId() {
        return medcardId;
    }

    public void setMedcardId(Medcard medcardId) {
        this.medcardId = medcardId;
    }

    public Policy getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Policy policyId) {
        this.policyId = policyId;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Patient[ id=" + id + " ]";
    }
    
}
