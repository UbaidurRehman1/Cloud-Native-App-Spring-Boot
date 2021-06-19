package com.ubaid.ms.ccdto;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.io.Serializable;
import java.time.Instant;

@RecordBuilder
public record AuditDTO(
        Long id,
        String userUUID,
        Instant timestamp,
        String fromCurrency,
        String toCurrency,
        float exchangeRate,
        float fromCurrencyValue,
        float toCurrencyValue,
        String userIPAddress,
        String currencyExchangeURL,
        String currencyConversionURL,
        int currencyExchangePort,
        int currencyConversionPort
) implements Serializable { }
