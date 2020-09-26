package com.ubaid.ms.restapi.controller;


import com.ubaid.ms.restapi.entity.Limit;
import com.ubaid.ms.restapi.feignProxy.LimitProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "splgbi")
@Slf4j
public class LimitController {

    private final LimitProxy proxy;

    @Autowired
    public LimitController(LimitProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/limits")
    public Limit getCurrencyConversion() {
        return proxy.getLimitConfig();
    }
}
