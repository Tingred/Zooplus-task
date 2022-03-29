package pl.zooplus.task.currency.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDTO {
    @JsonProperty("effectiveDate")
    private LocalDate date;
    @JsonProperty("bid")
    private BigDecimal sale;
    @JsonProperty("ask")
    private BigDecimal purchase;
}