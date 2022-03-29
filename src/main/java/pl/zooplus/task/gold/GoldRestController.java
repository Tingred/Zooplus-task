package pl.zooplus.task.gold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zooplus.task.gold.dto.AverageGoldPriceDTO;

@RestController
public class GoldRestController {
    @Autowired
    private GoldService goldService;

    @GetMapping(value = "/api/gold-price/average")
    public AverageGoldPriceDTO getExchangeRate() {
        return goldService.getAverageGoldPrice();
    }
}

