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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "item_goal_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemGoalPlan.findAll", query = "SELECT i FROM ItemGoalPlan i")
    , @NamedQuery(name = "ItemGoalPlan.findById", query = "SELECT i FROM ItemGoalPlan i WHERE i.id = :id")
    , @NamedQuery(name = "ItemGoalPlan.findByAnotation", query = "SELECT i FROM ItemGoalPlan i WHERE i.anotation = :anotation")
    , @NamedQuery(name = "ItemGoalPlan.findByEndDate", query = "SELECT i FROM ItemGoalPlan i WHERE i.endDate = :endDate")
    , @NamedQuery(name = "ItemGoalPlan.findByName", query = "SELECT i FROM ItemGoalPlan i WHERE i.name = :name")
    , @NamedQuery(name = "ItemGoalPlan.findByStartDate", query = "SELECT i FROM ItemGoalPlan i WHERE i.startDate = :startDate")})
public class ItemGoalPlan implements Serializable {

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
    @Column(name = "end_date")
    private String endDate;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "start_date")
    private String startDate;
    @JoinColumn(name = "goal_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Goal goalId;
    @JoinColumn(name = "acount_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Acount acountId;
    @OneToMany(mappedBy = "itemGoalPlanId", fetch = FetchType.LAZY)
    private List<ItemPlanToDay> itemPlanToDayList;

    public ItemGoalPlan() {
    }

    public ItemGoalPlan(Long id) {
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Goal getGoalId() {
        return goalId;
    }

    public void setGoalId(Goal goalId) {
        this.goalId = goalId;
    }

    public Acount getAcountId() {
        return acountId;
    }

    public void setAcountId(Acount acountId) {
        this.acountId = acountId;
    }

    @XmlTransient
    public List<ItemPlanToDay> getItemPlanToDayList() {
        return itemPlanToDayList;
    }

    public void setItemPlanToDayList(List<ItemPlanToDay> itemPlanToDayList) {
        this.itemPlanToDayList = itemPlanToDayList;
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
        if (!(object instanceof ItemGoalPlan)) {
            return false;
        }
        ItemGoalPlan other = (ItemGoalPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.ItemGoalPlan[ id=" + id + " ]";
    }
    
}
