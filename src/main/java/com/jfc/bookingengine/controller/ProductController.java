/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jfc
 */
@RequestMapping(value = "store")
public class ProductController {
    
    @RequestMapping(value = "getProduct")
    public String getProduct() {
        return "All Products";
    }
    
}
