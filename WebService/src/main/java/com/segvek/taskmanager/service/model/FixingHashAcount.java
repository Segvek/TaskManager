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
@Table(name="fixing_hash_acount")
public class FixingHashAcount extends Model {

    @ManyToOne
    @JoinColumn(name = "acount_id")
    private Acount acount;
    
    @ManyToOne
    @JoinColumn(name = "fixing_acout_id")
    private FixingAcount fixing;
    
    @Column(name = "value")
    private Double value;

    public Acount getAcount() {
        return acount;
    }

    public void setAcount(Acount acount) {
        this.acount = acount;
    }

    public FixingAcount getFixing() {
        return fixing;
    }

    public void setFixing(FixingAcount fixing) {
        this.fixing = fixing;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    

}
