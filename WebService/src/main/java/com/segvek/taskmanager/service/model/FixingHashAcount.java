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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panas
 */
@Entity
@Table(name = "fixing_hash_acount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FixingHashAcount.findAll", query = "SELECT f FROM FixingHashAcount f")
    , @NamedQuery(name = "FixingHashAcount.findById", query = "SELECT f FROM FixingHashAcount f WHERE f.id = :id")
    , @NamedQuery(name = "FixingHashAcount.findByValue", query = "SELECT f FROM FixingHashAcount f WHERE f.value = :value")})
public class FixingHashAcount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @JoinColumn(name = "fixing_acout_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FixingAcount fixingAcoutId;
    @JoinColumn(name = "acount_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Acount acountId;

    public FixingHashAcount() {
    }

    public FixingHashAcount(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public FixingAcount getFixingAcoutId() {
        return fixingAcoutId;
    }

    public void setFixingAcoutId(FixingAcount fixingAcoutId) {
        this.fixingAcoutId = fixingAcoutId;
    }

    public Acount getAcountId() {
        return acountId;
    }

    public void setAcountId(Acount acountId) {
        this.acountId = acountId;
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
        if (!(object instanceof FixingHashAcount)) {
            return false;
        }
        FixingHashAcount other = (FixingHashAcount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.segvek.taskmanager.service.model.FixingHashAcount[ id=" + id + " ]";
    }
    
}
