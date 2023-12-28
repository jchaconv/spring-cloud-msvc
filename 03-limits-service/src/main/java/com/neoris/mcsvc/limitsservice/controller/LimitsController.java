package com.neoris.mcsvc.limitsservice.controller;

import com.neoris.mcsvc.limitsservice.bean.Limits;
import com.neoris.mcsvc.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        //return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }



}
