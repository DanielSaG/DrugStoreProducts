/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@ApiModel(description = "Modelo de peticion para las operaciones de inventario")
public class ProductPackageRequest implements Serializable{
    
    private static final long serialVersionUID=1L;
    @ApiModelProperty(required = true, example = "45", notes="id del producto general")
    private long productId;
    @ApiModelProperty(required = true, example = "20", notes="id de la sucursal en donde se encuentra el articulo")
    private long locationId;
    @ApiModelProperty(required = true, example = "10", notes="cantidad disponible en existencia")
    private int quantity;
}
