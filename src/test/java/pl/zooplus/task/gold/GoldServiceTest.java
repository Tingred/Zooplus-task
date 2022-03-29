package pl.zooplus.task.gold;

import org.eclipse.collections.impl.collector.Collectors2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zooplus.task.gold.dto.GoldResponseDTO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoldServiceTest {
    @Mock
    private GoldService goldService;

    @BeforeEach
    void setUp() {
        goldService = new GoldService();
    }

    @Test
    @DisplayName("Test should pass when calculating average value is correct")
    public void shouldReturnAverageGoldPrice() {
        List<GoldResponseDTO> goldPriceList = List.of(
                new GoldResponseDTO().setDate(LocalDate.now()).setPrice(BigDecimal.valueOf(270.05)),
                new GoldResponseDTO().setDate(LocalDate.now()).setPrice(BigDecimal.valueOf(272.55)),
                new GoldResponseDTO().setDate(LocalDate.now()).setPrice(BigDecimal.valueOf(274.25)),
                new GoldResponseDTO().setDate(LocalDate.now()).setPrice(BigDecimal.valueOf(278.85)),
                new GoldResponseDTO().setDate(LocalDate.now()).setPrice(BigDecimal.valueOf(271.55)));

        List<BigDecimal> prices = goldPriceList.stream().map(body -> body.getPrice()).collect(Collectors.toList());
        BigDecimal average = prices.stream().collect(Collectors2.summarizingBigDecimal(d -> d))
                .getAverage(MathContext.DECIMAL32);

        assertEquals(BigDecimal.valueOf(273.45), average);
    }

    @Test
    @DisplayName("Should pass throwing null pointer exception")
    public void shouldThrowNullPointerException() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> goldService.getAverageGoldPrice());
    }
}