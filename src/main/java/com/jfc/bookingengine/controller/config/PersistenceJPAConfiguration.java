/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 *
 * @author jfc
 */
//@Configuration
//@EnableTransactionManagement
public class PersistenceJPAConfiguration {
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
    {
        return null;
    }
}
