/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "User")
public class User extends Model {

    @Column(name = "name", length = 50)
    private String name;
    
    @Column(name = "mail",length = 150)
    private String mail;
    
    @Column(name = "hashpass", length = 50)
    private String hashPass;
    
    @Column(name="confirmation", length = 50)
    private String confirmation;
    
    @Column(name="dateRegistration", length = 50)
    private String dateRegistration;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
    private List<Acount> acounts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
    private List<FixingAcount> fixingsAcounts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Goal> goals = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<PlanToDay> planToDay = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public List<Acount> getAcounts() {
        return acounts;
    }

    public void setAcounts(List<Acount> acounts) {
        this.acounts = acounts;
    }

    public List<FixingAcount> getFixingsAcounts() {
        return fixingsAcounts;
    }

    public void setFixingsAcounts(List<FixingAcount> fixingsAcounts) {
        this.fixingsAcounts = fixingsAcounts;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<PlanToDay> getPlanToDay() {
        return planToDay;
    }

    public void setPlanToDay(List<PlanToDay> planToDay) {
        this.planToDay = planToDay;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", mail=" + mail + ", hashPass=" + hashPass + ", confirmation=" + confirmation + ", acounts=" + acounts + ", fixingsAcounts=" + fixingsAcounts + ", goals=" + goals + ", planToDay=" + planToDay + '}';
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    
    
    
}
