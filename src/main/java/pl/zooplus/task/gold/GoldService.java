package pl.zooplus.task.gold;

import org.eclipse.collections.impl.collector.Collectors2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import pl.zooplus.task.ConsumingApiService;
import pl.zooplus.task.gold.dto.AverageGoldPriceDTO;
import pl.zooplus.task.gold.dto.GoldResponseDTO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoldService {
    @Autowired
    private ConsumingApiService consumingApiService;

    public AverageGoldPriceDTO getAverageGoldPrice() throws NullPointerException, RestClientException {
        List<GoldResponseDTO> goldPrice = consumingApiService.getGoldPrice();
        List<BigDecimal> prices = goldPrice.stream().map(body -> body.getPrice()).collect(Collectors.toList());
        BigDecimal average = prices.stream().collect(Collectors2.summarizingBigDecimal(d -> d))
                .getAverage(MathContext.DECIMAL32);
        return new AverageGoldPriceDTO().setAverage(average);
    }
}
