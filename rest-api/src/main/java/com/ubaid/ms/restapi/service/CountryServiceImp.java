package com.ubaid.ms.restapi.service;

import com.ubaid.ms.ccdto.CountryCodeDTO;
import com.ubaid.ms.restapi.feignProxy.CountryServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImp implements CountryService{

    private final CountryServiceProxy countryServiceProxy;

    @Override
    public List<CountryCodeDTO> getAll() {
        return countryServiceProxy.getAll();
    }
}
