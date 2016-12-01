/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "item_goal_plan")
public class ItemGoalPlan extends Model {

    @Column(name = "name")
    private String name;
    
    @Column(name="anotation")
    private String anotattion;
    
    @Column(name="start_date")
    private String startDate;
    
    @Column(name="end_date")
    private String endDate;
    
    @Column(name="state")
    private String state="Не начат";
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemGoalPlan")
    private List<ItemPlanToDay> itemsPlanToDay = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "acount_id")
    private Acount acount;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnotattion() {
        return anotattion;
    }

    public void setAnotattion(String anotattion) {
        this.anotattion = anotattion;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<ItemPlanToDay> getItemsPlanToDay() {
        return itemsPlanToDay;
    }

    public void setItemsPlanToDay(List<ItemPlanToDay> itemsPlanToDay) {
        this.itemsPlanToDay = itemsPlanToDay;
    }

    public Acount getAcount() {
        return acount;
    }

    public void setAcount(Acount acount) {
        this.acount = acount;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    
}
