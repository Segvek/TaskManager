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
import javax.persistence.Table;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "plan_to_day")
public class PlanToDay extends Model{
    
    @Column(name="date")
    private String date;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "planToDay")
    private List<ItemPlanToDay> itemPlanToDay = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ItemPlanToDay> getItemPlanToDay() {
        return itemPlanToDay;
    }

    public void setItemPlanToDay(List<ItemPlanToDay> itemPlanToDay) {
        this.itemPlanToDay = itemPlanToDay;
    }

}
