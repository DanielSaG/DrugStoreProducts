/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.controller;

import com.danielsg.drugstore.products.common.APIExcpetionResponse;
import com.danielsg.drugstore.products.dto.ProductRequest;
import com.danielsg.drugstore.products.dto.ProductResponse;
import com.danielsg.drugstore.products.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/products")
@Api(tags="Products API")
public class ProductController {
    private static final String RESOURCE_URI="/products/";
    @Autowired
    private ProductService productService;
    
    
    @ApiOperation(value="Retrieve all products",notes = "Return 204 if no data found",response = ProductResponse.class)
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = ProductResponse.class),
        @ApiResponse(code=204, message="No drugs founded"),
        @ApiResponse(code=206, message="Incomplete information"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> retrieveAllProducts(){
        return ResponseEntity.ok(productService.retrieveAllProducts());
    }
    
    @ApiOperation(value="Retrieve product by id",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = ProductResponse.class),
        @ApiResponse(code=206, message="Incomplete information", response = ProductResponse.class),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=404, message="Drug not found"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> retrieveProductById(@PathVariable long productId){
        return ResponseEntity.ok(productService.retrieveProductById(productId));
    }
    
    
    @ApiOperation(value="Create product",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=201, message="Product created", responseHeaders = {
                    @ResponseHeader(
                            name = "Location",
                            description = "The created resource id", 
                            response = String.class)}),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productReq){
        long id=productService.createProduct(productReq);
        return ResponseEntity.created(URI.create(RESOURCE_URI+id)).build();
    }
    
    
    @ApiOperation(value="Update prduct",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="product updated"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable long productId, @RequestBody ProductRequest productReq){
        productService.updateProduct(productId, productReq);
        return ResponseEntity.noContent().build();
    }
    
    
    @ApiOperation(value="Update product partial",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Product updated"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PatchMapping("/{productId}")
    public ResponseEntity<?> updateProductPartial(@PathVariable long productId, @RequestBody ProductRequest productReq){
        productService.updatePartialProduct(productId, productReq);
        return ResponseEntity.noContent().build();
    }
    
    @ApiOperation(value="Delete product",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Product succesfully deleted"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
