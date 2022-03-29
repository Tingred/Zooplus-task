package pl.zooplus.task.currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {
    @Mock
    private CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        currencyService = new CurrencyService();
    }

    @Test
    @DisplayName("Should divide one by value")
    public void shouldFlipToOnePLNValue() {
        BigDecimal testValue = BigDecimal.valueOf(5.67);
        BigDecimal divide = BigDecimal.valueOf(1).divide(testValue, MathContext.DECIMAL32);

        assertEquals(divide, currencyService.flipToOnePLNValue(testValue));
    }

    @Test
    @DisplayName("Should pass throwing arithmetic exception")
    public void shouldFlipToOnePLNValueThrowArithmeticException() {
        BigDecimal testValue = BigDecimal.valueOf(0);

        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> currencyService.flipToOnePLNValue(testValue));
    }

    @Test
    @DisplayName("Should pass throwing null pointer exception")
    public void shouldThrowNullPointerException() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> currencyService.getExchangeRates("USD"));
    }
}