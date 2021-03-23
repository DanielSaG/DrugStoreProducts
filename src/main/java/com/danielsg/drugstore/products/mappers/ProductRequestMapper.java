/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.mappers;

import com.danielsg.drugstore.products.dto.ProductRequest;
import com.danielsg.drugstore.products.entities.Product;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author danie
 */
@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    
    Product ProductResponseToProduct(ProductRequest source);
    List<Product> ProductResponseListToProductList(List<ProductRequest> source);
    ProductRequest ProductToProductResponse(Product source);
    List<ProductRequest> ProductListToProductResponseList(List<Product> source);
}
