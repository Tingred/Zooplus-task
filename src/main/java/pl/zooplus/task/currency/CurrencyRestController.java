package pl.zooplus.task.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.zooplus.task.currency.dto.ExchangeRateDTO;

import java.util.Set;

@RestController
public class CurrencyRestController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping(value = "/api/exchange-rates/{currencyCode}")
    public Set<ExchangeRateDTO> getExchangeRate(@PathVariable("currencyCode") String currencyCode) {
        return currencyService.getExchangeRates(currencyCode);
    }
}
