/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByConfirmation", query = "SELECT u FROM User u WHERE u.confirmation = :confirmation")
    , @NamedQuery(name = "User.findByDateRegistration", query = "SELECT u FROM User u WHERE u.dateRegistration = :dateRegistration")
    , @NamedQuery(name = "User.findByHashpass", query = "SELECT u FROM User u WHERE u.hashpass = :hashpass")
    , @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "confirmation")
    private String confirmation;
    @Size(max = 50)
    @Column(name = "dateRegistration")
    private String dateRegistration;
    @Size(max = 50)
    @Column(name = "hashpass")
    private String hashpass;
    @Size(max = 150)
    @Column(name = "mail")
    private String mail;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<FixingAcount> fixingAcountList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Acount> acountList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Goal> goalList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<PlanToDay> planToDayList;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getHashpass() {
        return hashpass;
    }

    public void setHashpass(String hashpass) {
        this.hashpass = hashpass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<FixingAcount> getFixingAcountList() {
        return fixingAcountList;
    }

    public void setFixingAcountList(List<FixingAcount> fixingAcountList) {
        this.fixingAcountList = fixingAcountList;
    }

    @XmlTransient
    public List<Acount> getAcountList() {
        return acountList;
    }

    public void setAcountList(List<Acount> acountList) {
        this.acountList = acountList;
    }

    @XmlTransient
    public List<Goal> getGoalList() {
        return goalList;
    }

    public void setGoalList(List<Goal> goalList) {
        this.goalList = goalList;
    }

    @XmlTransient
    public List<PlanToDay> getPlanToDayList() {
        return planToDayList;
    }

    public void setPlanToDayList(List<PlanToDay> planToDayList) {
        this.planToDayList = planToDayList;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.User[ id=" + id + " ]";
    }
    
}
