package com.ubaid.ms.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubaid.ms.entity.CurrencyConversion;
import com.ubaid.ms.feignProxy.FeignProxy;

@RestController
@RequestMapping("currency-conversion-feign")
public class CurrenyConversionControllerFeign
{
	@Autowired
	private FeignProxy proxy;
	
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity)
	{
		CurrencyConversion currencyConversion = proxy.getCurrentConversion(from, to);
		currencyConversion.setQuantity(quantity);
		return currencyConversion;
	}
	
}
