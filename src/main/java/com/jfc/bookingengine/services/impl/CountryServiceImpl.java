/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.services.impl;

import com.jfc.bookingengine.dao.CountryRepository;
import com.jfc.bookingengine.dto.Country;
import com.jfc.bookingengine.services.CountryService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jfc
 */
@Stateless
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Inject
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryServiceImpl() {
    }

    @Override
    public List<Country> get() throws Exception {
        return countryRepository.findAll();
    }

    @Override
    public Country get(int id) throws Exception {
        return countryRepository.findById(id);
    }

    @Override
    public void update(Country value) throws Exception {
        countryRepository.update(value);
    }

    @Override
    public void create(Country value) throws Exception {
        countryRepository.add(value);
    }

    @Override
    public void delete(int id) throws Exception {
        countryRepository.remove(id);
    }

}
