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
@Table(name = "doctor")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findById", query = "SELECT d FROM Doctor d WHERE d.id = :id"),
    @NamedQuery(name = "Doctor.findByName", query = "SELECT d FROM Doctor d WHERE d.name = :name"),
    @NamedQuery(name = "Doctor.findBySurname", query = "SELECT d FROM Doctor d WHERE d.surname = :surname"),
    @NamedQuery(name = "Doctor.findByPatronymic", query = "SELECT d FROM Doctor d WHERE d.patronymic = :patronymic"),
    @NamedQuery(name = "Doctor.findByPassportNumber", query = "SELECT d FROM Doctor d WHERE d.passportNumber = :passportNumber"),
    @NamedQuery(name = "Doctor.findByPassportSeries", query = "SELECT d FROM Doctor d WHERE d.passportSeries = :passportSeries"),
    @NamedQuery(name = "Doctor.findByDateOfBith", query = "SELECT d FROM Doctor d WHERE d.dateOfBith = :dateOfBith"),
    @NamedQuery(name = "Doctor.findByPhonenumber", query = "SELECT d FROM Doctor d WHERE d.phonenumber = :phonenumber"),
    @NamedQuery(name = "Doctor.findByGender", query = "SELECT d FROM Doctor d WHERE d.gender = :gender"),
    @NamedQuery(name = "Doctor.findByLogin", query = "SELECT d FROM Doctor d WHERE d.login = :login"),
    @NamedQuery(name = "Doctor.findByPassword", query = "SELECT d FROM Doctor d WHERE d.password = :password")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<MeasuserDoctor> measuserDoctorCollection;
    
    public List<Doctor> getDoctorPassword(String login, String password, EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Doctor> cq = cb.createQuery(Doctor.class);
        Root<Doctor> root = cq.from(Doctor.class);
        cq.select(root).where(cb.and(cb.equal(root.get(Doctor_.login), login),
                cb.equal(root.get(Doctor_.password), password)));
        TypedQuery query = em.createQuery(cq);
        List<Doctor> userLoginPassword = query.getResultList();
        return userLoginPassword;
    }

    public Doctor() {
    }

    public Doctor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<MeasuserDoctor> getMeasuserDoctorCollection() {
        return measuserDoctorCollection;
    }

    public void setMeasuserDoctorCollection(Collection<MeasuserDoctor> measuserDoctorCollection) {
        this.measuserDoctorCollection = measuserDoctorCollection;
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
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Doctor[ id=" + id + " ]";
    }
    
}
