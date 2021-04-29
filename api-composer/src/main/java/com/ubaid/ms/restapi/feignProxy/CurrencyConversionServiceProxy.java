package com.ubaid.ms.restapi.feignProxy;

import com.ubaid.ms.ccdto.ConvertedCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "spring-cloud-api-gateway-server")
public interface CurrencyConversionServiceProxy {

    @GetMapping("currency-conversion/currency/{currency}/rate/{conversion-rate}")
    ConvertedCurrency convert(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("currency") Double currency,
            @PathVariable("conversion-rate") Double rate);
}
