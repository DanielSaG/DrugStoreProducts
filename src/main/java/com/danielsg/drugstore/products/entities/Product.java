/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@Entity
public class Product implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private long productId;
    private String type;
    @Column(name="id_spec")
    private long specId;
    
    
    public void merge(Product extern){
        if(extern==null)
            return;
        this.type=extern.type!=null?extern.type:this.type;
        this.specId=extern.specId > 0L && extern.specId != 0L?extern.specId:this.specId;
    }
    
    
}
