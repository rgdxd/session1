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
@Table(name = "recipe")
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id"),
    @NamedQuery(name = "Recipe.findByMedication", query = "SELECT r FROM Recipe r WHERE r.medication = :medication"),
    @NamedQuery(name = "Recipe.findByReceptionFormat", query = "SELECT r FROM Recipe r WHERE r.receptionFormat = :receptionFormat")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "medication")
    private String medication;
    @Column(name = "reception_format")
    private String receptionFormat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeId")
    private Collection<RecipeMedcard> recipeMedcardCollection;
    
     public List<Recipe> getRecipeList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Recipe.class);
        Root<Recipe> root = cq.from(Recipe.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Recipe> userList = query.getResultList();
        return userList;
    }
    
    public void addRecipe(Recipe rec, EntityManager em) {
        em.getTransaction().begin();
        em.persist(rec);
        em.getTransaction().commit();
    }
    
    public void upDateRecipe(Recipe rec, EntityManager em) {
        em.getTransaction().begin();
        Recipe r = em.find(Recipe.class, rec.getId());
        r.setMedication(rec.getMedication());
        r.setReceptionFormat(rec.getReceptionFormat());
        em.merge(r);
        em.getTransaction().commit();
    }
    
    public void deleteRecipe(Recipe rec, EntityManager em) {
        em.getTransaction().begin();
        Recipe r = em.find(Recipe.class, rec.getId());
        em.remove(r);
        em.getTransaction().commit();
    }


    public Recipe() {
    }

    public Recipe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getReceptionFormat() {
        return receptionFormat;
    }

    public void setReceptionFormat(String receptionFormat) {
        this.receptionFormat = receptionFormat;
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
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isp.hos.entity.Recipe[ id=" + id + " ]";
    }
    
}
