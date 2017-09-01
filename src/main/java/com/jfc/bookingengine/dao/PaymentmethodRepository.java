/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dao;

import com.jfc.bookingengine.dao.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author jfc
 */
public interface PaymentmethodRepository {
    
    /**
     * @param <T>
     * @param t
     * @throws com.jfc.bookingengine.dao.RepositoryException
     */
    public <T>void add(T t) throws RepositoryException;
    /**
     * @param <T>
     * @return
     * @throws com.jfc.bookingengine.dao.RepositoryException */
    public <T>List<T> findAll() throws RepositoryException;
    /**
     * @param <T>
     * @param t*
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public <T>void update(T t) throws RepositoryException;
    /**
     * @param <T>
     * @param t
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public <T>void remove(T t) throws RepositoryException;
    /**
     * @param <T>
     * @param t
     * @return 
     * @throws com.jfc.bookingengine.dao.RepositoryException*/
    public <T>T findById(T t) throws RepositoryException;

}
