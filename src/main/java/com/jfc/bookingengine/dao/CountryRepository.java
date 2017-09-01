/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dao;

import com.jfc.bookingengine.dao.exception.RepositoryException;
import com.jfc.bookingengine.dto.Country;
import java.util.List;

/**
 *
 * @author jfc
 */
public interface CountryRepository {
    
    /**
     * @param t
     * @throws com.jfc.bookingengine.dao.RepositoryException
     */
    public void add(Country t) throws RepositoryException;
    /**
     * @return
     * @throws com.jfc.bookingengine.dao.RepositoryException */
    public List<Country> findAll() throws RepositoryException;
    /**
     * @param t*
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public void update(Country t) throws RepositoryException;
    /**
     * @param t
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public void remove(int t) throws RepositoryException;
    /**
     * @param t
     * @return 
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public Country findById(int t) throws RepositoryException;

}
