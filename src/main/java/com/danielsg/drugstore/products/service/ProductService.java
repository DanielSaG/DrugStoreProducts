/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.service;

import com.danielsg.drugstore.products.dto.ProductRequest;
import com.danielsg.drugstore.products.dto.ProductResponse;
import java.util.List;

/**
 *
 * @author danie
 */

public interface ProductService {
    public long createProduct(ProductRequest req);
    public List<ProductResponse> retrieveAllProducts();
    public ProductResponse retrieveProductById(long id);
    public void updateProduct(long id, ProductRequest req);
    public void updatePartialProduct(long id, ProductRequest req);
    public void deleteProduct(long id);
}
