/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "item_plan_to_day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPlanToDay.findAll", query = "SELECT i FROM ItemPlanToDay i")
    , @NamedQuery(name = "ItemPlanToDay.findById", query = "SELECT i FROM ItemPlanToDay i WHERE i.id = :id")
    , @NamedQuery(name = "ItemPlanToDay.findByAnotation", query = "SELECT i FROM ItemPlanToDay i WHERE i.anotation = :anotation")
    , @NamedQuery(name = "ItemPlanToDay.findByName", query = "SELECT i FROM ItemPlanToDay i WHERE i.name = :name")
    , @NamedQuery(name = "ItemPlanToDay.findByStatus", query = "SELECT i FROM ItemPlanToDay i WHERE i.status = :status")
    , @NamedQuery(name = "ItemPlanToDay.findByTimeNotifice", query = "SELECT i FROM ItemPlanToDay i WHERE i.timeNotifice = :timeNotifice")})
public class ItemPlanToDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "anotation")
    private String anotation;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "time_notifice")
    private String timeNotifice;
    @JoinColumn(name = "plan_to_day_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PlanToDay planToDayId;
    @JoinColumn(name = "item_goal_plan_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemGoalPlan itemGoalPlanId;

    public ItemPlanToDay() {
    }

    public ItemPlanToDay(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnotation() {
        return anotation;
    }

    public void setAnotation(String anotation) {
        this.anotation = anotation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeNotifice() {
        return timeNotifice;
    }

    public void setTimeNotifice(String timeNotifice) {
        this.timeNotifice = timeNotifice;
    }

    public PlanToDay getPlanToDayId() {
        return planToDayId;
    }

    public void setPlanToDayId(PlanToDay planToDayId) {
        this.planToDayId = planToDayId;
    }

    public ItemGoalPlan getItemGoalPlanId() {
        return itemGoalPlanId;
    }

    public void setItemGoalPlanId(ItemGoalPlan itemGoalPlanId) {
        this.itemGoalPlanId = itemGoalPlanId;
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
        if (!(object instanceof ItemPlanToDay)) {
            return false;
        }
        ItemPlanToDay other = (ItemPlanToDay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.ItemPlanToDay[ id=" + id + " ]";
    }
    
}
