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
@Table(name = "plan_to_day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanToDay.findAll", query = "SELECT p FROM PlanToDay p")
    , @NamedQuery(name = "PlanToDay.findById", query = "SELECT p FROM PlanToDay p WHERE p.id = :id")
    , @NamedQuery(name = "PlanToDay.findByDate", query = "SELECT p FROM PlanToDay p WHERE p.date = :date")})
public class PlanToDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "date")
    private String date;
    @OneToMany(mappedBy = "planToDayId", fetch = FetchType.LAZY)
    private List<ItemPlanToDay> itemPlanToDayList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    public PlanToDay() {
    }

    public PlanToDay(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public List<ItemPlanToDay> getItemPlanToDayList() {
        return itemPlanToDayList;
    }

    public void setItemPlanToDayList(List<ItemPlanToDay> itemPlanToDayList) {
        this.itemPlanToDayList = itemPlanToDayList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof PlanToDay)) {
            return false;
        }
        PlanToDay other = (PlanToDay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.PlanToDay[ id=" + id + " ]";
    }
    
}
