package pl.zooplus.task.gold.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AverageGoldPriceDTO {
    private BigDecimal average;
}
