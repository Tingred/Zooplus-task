package pl.zooplus.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.zooplus.task.currency.dto.CurrencyExchangeResponseDTO;
import pl.zooplus.task.gold.dto.GoldResponseDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ConsumingApiService {

    @Autowired
    private RestTemplate restTemplate;

    public CurrencyExchangeResponseDTO getExchangeRate(String currencyCode) throws NullPointerException, RestClientException {
        return Objects.requireNonNull(restTemplate
                .getForObject("https://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/last/5?format=json", CurrencyExchangeResponseDTO.class));
    }

    public List<GoldResponseDTO> getGoldPrice() throws NullPointerException, RestClientException {
        return Arrays.asList(Objects.requireNonNull(restTemplate
                .getForObject("http://api.nbp.pl/api/cenyzlota/last/14/?format=json", GoldResponseDTO[].class)));
    }
}
