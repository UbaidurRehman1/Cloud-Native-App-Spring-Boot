package com.ubaid.ms.ccdto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryCodeDTO {
    private Long id;
    private String country;
    private String currencyName;
    private String currencyCode;
    private Integer number;
}
