/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.bookingengine.controller;

import com.jfc.bookingengine.services.CountryService;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jfc
 */
@Controller
@RequestMapping("country")
public class CountryController {

    @Inject CountryService countryService;

    @ResponseBody
    @RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
    public String list(Map<String, Object> model) throws Exception
    {
        //model.put("countries", countryService.get());
        return "countries/list";
    }
}
