/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.dao.impl;

import com.jfc.bookingengine.dao.exception.RepositoryException;
import com.jfc.bookingengine.dao.RoomRepository;
import com.jfc.bookingengine.dto.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jfc
 */
public class RoomRepositoryImpl implements RoomRepository {

    @PersistenceContext(unitName = "bookingenginePU")
    EntityManager entityManager;

    @Override
    public <T> void add(T t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createNamedQuery("Room.findAll").getResultList();
    }

    @Override
    public <T> void update(T t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public <T> void remove(T t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public <T> T findById(T t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        Query createNamedQuery = entityManager.createNamedQuery("Room.findByRoomId");
        List resultList = null;
        try {
            transaction.begin();
            createNamedQuery.setParameter("roomId", t);
            resultList = createNamedQuery.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
        return resultList != null ? (T) resultList.get(0) : null;
    }
}
