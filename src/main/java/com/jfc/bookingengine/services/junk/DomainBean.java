/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.services.junk;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author jfc
 */
@Stateful
@Named
public class DomainBean {
    
    public String callMe()
    {
        return "Domain is called again ";
    }
}
