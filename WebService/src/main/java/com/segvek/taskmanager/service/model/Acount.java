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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="acount")
public class Acount extends Model {
    
    @Column(name = "name",length = 150)
    private String name;
    
    @Column(name = "annitation",length = 1500)
    private String annitation;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "acount")
    private List<FixingHashAcount> fha = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToOne(mappedBy = "acount",fetch = FetchType.LAZY)
    private ItemGoalPlan itemGoalPlan;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnitation() {
        return annitation;
    }

    public void setAnnitation(String annitation) {
        this.annitation = annitation;
    }

    public List<FixingHashAcount> getFha() {
        return fha;
    }

    public void setFha(List<FixingHashAcount> fha) {
        this.fha = fha;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ItemGoalPlan getItemGoalPlan() {
        return itemGoalPlan;
    }

    public void setItemGoalPlan(ItemGoalPlan itemGoalPlan) {
        this.itemGoalPlan = itemGoalPlan;
    }

    

}
