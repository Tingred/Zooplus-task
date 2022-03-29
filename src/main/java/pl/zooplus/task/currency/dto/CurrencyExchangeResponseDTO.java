package pl.zooplus.task.currency.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangeResponseDTO {
    private String code;
    private Set<ExchangeRateDTO> rates;
}
