/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.dao;

import com.danielsg.drugstore.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danie
 */
public interface ProductDao extends JpaRepository<Product, Long>{
    
}
