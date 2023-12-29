package com.neoris.mcsvc.currencyconversionservice.client;

import com.neoris.mcsvc.currencyconversionservice.entities.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
