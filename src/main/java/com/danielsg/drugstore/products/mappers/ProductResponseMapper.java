/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.mappers;


import com.danielsg.drugstore.products.dto.ProductResponse;
import com.danielsg.drugstore.products.entities.Product;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author danie
 */
@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    Product ProductResponseToProduct(ProductResponse source);
    List<Product> ProductResponseListToProductList(List<ProductResponse> source);
    ProductResponse ProductToProductResponse(Product source);
    List<ProductResponse> ProductListToProductResponseList(List<Product> source);
}
