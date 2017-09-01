/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.services;

import com.jfc.bookingengine.dto.Country;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jfc
 */
public interface CountryService {

    /**
     *
     * @return @throws Exception
     */
    @NotNull
    List<Country> get() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Country get(@Min(0) int id) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void update(@NotNull @Valid Country value) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void create(@NotNull Country value) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(@Min(0) int id) throws Exception;
}
