package pl.zooplus.task.gold.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldResponseDTO {
    @JsonProperty("data")
    private LocalDate date;
    @JsonProperty("cena")
    private BigDecimal price;
}
