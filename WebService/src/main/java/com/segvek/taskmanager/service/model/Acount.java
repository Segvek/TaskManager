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
import javax.persistence.Lob;
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
@Table(name = "acount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acount.findAll", query = "SELECT a FROM Acount a")
    , @NamedQuery(name = "Acount.findById", query = "SELECT a FROM Acount a WHERE a.id = :id")
    , @NamedQuery(name = "Acount.findByName", query = "SELECT a FROM Acount a WHERE a.name = :name")})
public class Acount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "annitation")
    private String annitation;
    @Size(max = 150)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "acountId", fetch = FetchType.LAZY)
    private List<FixingHashAcount> fixingHashAcountList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(mappedBy = "acountId", fetch = FetchType.LAZY)
    private List<ItemGoalPlan> itemGoalPlanList;

    public Acount() {
    }

    public Acount(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnitation() {
        return annitation;
    }

    public void setAnnitation(String annitation) {
        this.annitation = annitation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<FixingHashAcount> getFixingHashAcountList() {
        return fixingHashAcountList;
    }

    public void setFixingHashAcountList(List<FixingHashAcount> fixingHashAcountList) {
        this.fixingHashAcountList = fixingHashAcountList;
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
        if (!(object instanceof Acount)) {
            return false;
        }
        Acount other = (Acount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.Acount[ id=" + id + " ]";
    }
    
}
