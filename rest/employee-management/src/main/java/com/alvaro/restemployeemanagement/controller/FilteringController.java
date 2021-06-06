package com.alvaro.restemployeemanagement.controller;

import com.alvaro.restemployeemanagement.model.UserDetails;
import com.alvaro.restemployeemanagement.repo.UserDetailsRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @Autowired
    private UserDetailsRepository detailsRepository;

    @GetMapping("/filter1")
    public List<UserDetails> getAllUserDetails() {
        return (List<UserDetails>) detailsRepository.findAll();
    }

    @GetMapping("/filter2")
    public MappingJacksonValue getAllUserDetailsDynFilter() {
        List<UserDetails> all = (List<UserDetails>) detailsRepository.findAll();

        SimpleBeanPropertyFilter userIdFilter = SimpleBeanPropertyFilter
            .filterOutAllExcept("userId");
        FilterProvider filtered = new SimpleFilterProvider().addFilter("userDetails", userIdFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(all);
        mappingJacksonValue.setFilters(filtered);

        return mappingJacksonValue;
    }
}
