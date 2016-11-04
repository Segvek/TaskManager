/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "item_plan_to_day")
public class ItemPlanToDay extends Model{
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "anotation")
    private String anotation;
    
    @Column(name="status")
    private String status;
    
    @Column(name = "time_notifice")
    private String timeNotice;
    
    @ManyToOne
    @JoinColumn(name = "plan_to_day_id")
    private PlanToDay planToDay;
    
    @ManyToOne
    @JoinColumn(name = "item_goal_plan_id")
    private ItemGoalPlan itemGoalPlan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnotation() {
        return anotation;
    }

    public void setAnotation(String anotation) {
        this.anotation = anotation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeNotice() {
        return timeNotice;
    }

    public void setTimeNotice(String timeNotice) {
        this.timeNotice = timeNotice;
    }

    public PlanToDay getPlanToDay() {
        return planToDay;
    }

    public void setPlanToDay(PlanToDay planToDay) {
        this.planToDay = planToDay;
    }

    public ItemGoalPlan getItemGoalPlan() {
        return itemGoalPlan;
    }

    public void setItemGoalPlan(ItemGoalPlan itemGoalPlan) {
        this.itemGoalPlan = itemGoalPlan;
    }

}
