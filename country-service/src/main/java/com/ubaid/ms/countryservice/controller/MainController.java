package com.ubaid.ms.countryservice.controller;

import com.ubaid.ms.ccdto.CountryCodeDTO;
import com.ubaid.ms.countryservice.service.CountryCodeService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("country")
@RequiredArgsConstructor
public class MainController {

    private final CountryCodeService countryCodeService;

    @PreAuthorize("hasAuthority('SCOPE_countries')")
    @GetMapping("code")
    public List<CountryCodeDTO> getAll() {
        return countryCodeService.getAll();
    }
}
