package com.ubaid.ms.restapi.feignProxy;

import com.ubaid.ms.ccdto.CountryCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("spring-cloud-api-gateway-server")
public interface CountryServiceProxy {

    @GetMapping("/country/code")
    List<CountryCodeDTO> getAll();
}
