/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.service;

import com.danielsg.drugstore.products.common.ProductPackageRequest;
import com.danielsg.drugstore.products.common.ProductPackageResponse;
import com.danielsg.drugstore.products.dao.ProductDao;
import com.danielsg.drugstore.products.dto.ProductRequest;
import com.danielsg.drugstore.products.dto.ProductResponse;
import com.danielsg.drugstore.products.entities.Product;
import com.danielsg.drugstore.products.mappers.ProductRequestMapper;
import com.danielsg.drugstore.products.mappers.ProductResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author danie
 */
@Service
public class ProductServiceImp  implements ProductService{
    
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductRequestMapper reqMapper;
    @Autowired
    private ProductResponseMapper respMapper;
    @Autowired
    private RestTemplate restTemplate;
    
    

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long createProduct(ProductRequest req) {
        
        Product prod=reqMapper.ProductResponseToProduct(req);
        prod = productDao.save(prod);
        ProductPackageRequest ppReq=new ProductPackageRequest();
        ppReq.setLocationId((int)(Math.random()*100));//construir servicio de sucursales
        ppReq.setProductId(prod.getProductId());
        ppReq.setQuantity(req.getQuantity());
        restTemplate.postForEntity("http://inventory-product/api/sps/helloworld/v1/inventory", ppReq, ProductPackageResponse.class);
        return prod.getProductId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> retrieveAllProducts() {
        return respMapper.ProductListToProductResponseList(productDao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse retrieveProductById(long id) {
        return respMapper.ProductToProductResponse(productDao.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductRequest req) {
        Product product=reqMapper.ProductResponseToProduct(req);
        product.setProductId(id);
        productDao.save(product);
    }

    @Override
    @Transactional
    public void updatePartialProduct(long id, ProductRequest req){
        Product product=productDao.findById(id).orElse(null);
        if(product==null)
            return;
        product.merge(reqMapper.ProductResponseToProduct(req));
        productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        Product product =new Product();
        product.setProductId(id);
        productDao.delete(product);
    }
    
}
