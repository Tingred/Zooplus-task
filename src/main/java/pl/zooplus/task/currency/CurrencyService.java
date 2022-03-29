package pl.zooplus.task.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import pl.zooplus.task.ConsumingApiService;
import pl.zooplus.task.currency.dto.ExchangeRateDTO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    @Autowired
    private ConsumingApiService consumingApiService;

    public Set<ExchangeRateDTO> getExchangeRates(String currencyCode) throws ArithmeticException, NullPointerException, RestClientException {
        Set<ExchangeRateDTO> rates = consumingApiService.getExchangeRate(currencyCode).getRates();
        return rates.stream()
                .map(r ->
                        new ExchangeRateDTO()
                                .setDate(r.getDate())
                                .setPurchase(flipToOnePLNValue(r.getPurchase()))
                                .setSale(flipToOnePLNValue(r.getSale())))
                .collect(Collectors.toSet());
    }

    public BigDecimal flipToOnePLNValue(BigDecimal rate) throws ArithmeticException {
        return BigDecimal.ONE.divide(rate, MathContext.DECIMAL32);
    }
}
