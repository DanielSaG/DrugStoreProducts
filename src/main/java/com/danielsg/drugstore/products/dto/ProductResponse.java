/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@ApiModel(description = "Modelo de respuesta de producto")
public class ProductResponse implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    
    @ApiModelProperty(required = true, example = "45", notes = "id general del producto")
    private long productId;
    @ApiModelProperty(required = true, example = "medicina", notes = "Tipo de producto: medicina, comida, bebida, insumo medico, etc...")
    private String type;
    @ApiModelProperty(required = true, example = "23", notes = "id especializado del producto: drugId, etc...")
    private long specId;
}
