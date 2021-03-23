/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@ApiModel(description="Api response for an exception")
public class APIExcpetionResponse {
    @ApiModelProperty(required=true, example="errors/authorization/not-authorized", notes="URI que categoriza el error")
    private String type="errors/uncategorized";
    @ApiModelProperty(required=true, example="the user is not authorized", notes="Mensaje descriptivo del error")
    private String title;
    @ApiModelProperty(required=true, example="150", notes="codigo unico de error")
    private String code;
    @ApiModelProperty(required=true, example="The user dos not has permisions to acces this resource", notes="explicacion del error")
    private String detail;
    @ApiModelProperty(required=true, example="errors/authorization/not-authorized/1", notes="URI que especifica el error")
    private String instance="errors/uncategorized/drugstore";
}
