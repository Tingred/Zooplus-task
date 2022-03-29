package pl.zooplus.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class ConsumingApiServiceTest {
    @Mock
    private ConsumingApiService consumingApi;

    @BeforeEach
    void setUp() {
        consumingApi = new ConsumingApiService();
    }
    
    @Test
    @DisplayName("Should pass when getGoldPrice throws null pointer exception")
    public void getGoldPriceShouldThrowNullPointerException(){
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(()-> consumingApi.getGoldPrice());
    }

    @Test
    @DisplayName("Should pass when getExchangeRate throws null pointer exception")
    public void getExchangeRateShouldThrowNullPointerException(){
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(()-> consumingApi.getExchangeRate("USD"));
    }
}