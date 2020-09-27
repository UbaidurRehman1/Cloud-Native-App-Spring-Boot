package com.ubaid.ms.currency_conversion_service.restapi.service;

import com.ubaid.ms.currency_conversion_service.restapi.feignProxy.CurrencyConversionServiceProxy;
import com.ubaid.ms.currency_conversion_service.restapi.feignProxy.CurrencyExchangeServiceProxy;
import com.ubaid.ms.currency_conversion_service.restapi.dto.ConvertedCurrency;
import com.ubaid.ms.currency_conversion_service.restapi.dto.ExchangeValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionServiceImp implements CurrencyConversionService {

    private final CurrencyExchangeServiceProxy exchangeServiceProxy;
    private final CurrencyConversionServiceProxy conversionServiceProxy;

    @Autowired
    public CurrencyConversionServiceImp(CurrencyExchangeServiceProxy exchangeServiceProxy, CurrencyConversionServiceProxy conversionServiceProxy) {
        this.exchangeServiceProxy = exchangeServiceProxy;
        this.conversionServiceProxy = conversionServiceProxy;
    }

    @Override
    public ExchangeValueDTO convertCurrency(String fromCurrency, String toCurrency, Integer quantity) {
        ExchangeValueDTO exchangeValueDTO = exchangeServiceProxy.getCurrencyExchangeRate(fromCurrency, toCurrency);
        ConvertedCurrency convertedCurrency = conversionServiceProxy.convert(quantity, exchangeValueDTO.getExchangeRate());
        exchangeValueDTO.setExchangedCurrencyQuantity(convertedCurrency.getConvertedCurrency());
        exchangeValueDTO.setQuantity(quantity);
        return exchangeValueDTO;
    }
}
