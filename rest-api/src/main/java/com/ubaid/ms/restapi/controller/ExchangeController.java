package com.ubaid.ms.restapi.controller;

import com.ubaid.ms.ccdto.ExchangeValueDTO;
import com.ubaid.ms.restapi.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;

@RestController
@RequestMapping(value = "/api/exchange")
@Slf4j
@CrossOrigin(value = CorsConfiguration.ALL)
@RequiredArgsConstructor
public class ExchangeController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/{from}/to/{to}/q/{quantity}")
    public ExchangeValueDTO getCurrencyConversion(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") Double quantity) {
        return currencyConversionService.convertCurrency(from, to, quantity);
    }
}
