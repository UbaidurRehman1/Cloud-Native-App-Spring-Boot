package com.ubaid.ms.currencyconversionapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConvertedCurrency {
    private Integer port;
    private Integer convertedCurrency;
}
