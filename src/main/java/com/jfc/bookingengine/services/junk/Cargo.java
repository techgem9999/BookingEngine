/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.services.junk;

import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author jfc
 */
public class Cargo {

    public String method() {
        return "Cargo ";
    }

    /**
     *
     * @return
     */
    @Produces
    @Informal   
    public List<String> list() {
        return Arrays.asList("a", "b", "c");
    }

}
