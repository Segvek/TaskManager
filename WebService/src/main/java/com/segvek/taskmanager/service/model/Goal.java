/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "goal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goal.findAll", query = "SELECT g FROM Goal g")
    , @NamedQuery(name = "Goal.findById", query = "SELECT g FROM Goal g WHERE g.id = :id")
    , @NamedQuery(name = "Goal.findByAnnotation", query = "SELECT g FROM Goal g WHERE g.annotation = :annotation")
    , @NamedQuery(name = "Goal.findByEndDate", query = "SELECT g FROM Goal g WHERE g.endDate = :endDate")
    , @NamedQuery(name = "Goal.findByName", query = "SELECT g FROM Goal g WHERE g.name = :name")
    , @NamedQuery(name = "Goal.findByStartDate", query = "SELECT g FROM Goal g WHERE g.startDate = :startDate")})
public class Goal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "annotation")
    private String annotation;
    @Size(max = 255)
    @Column(name = "endDate")
    private String endDate;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "startDate")
    private String startDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(mappedBy = "goalId", fetch = FetchType.LAZY)
    private List<ItemGoalPlan> itemGoalPlanList= new ArrayList<>();

    public Goal() {
    }

    public Goal(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<ItemGoalPlan> getItemGoalPlanList() {
        return itemGoalPlanList;
    }

    public void setItemGoalPlanList(List<ItemGoalPlan> itemGoalPlanList) {
        this.itemGoalPlanList = itemGoalPlanList;
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
        if (!(object instanceof Goal)) {
            return false;
        }
        Goal other = (Goal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.Goal[ id=" + id + " ]";
    }
    
}
