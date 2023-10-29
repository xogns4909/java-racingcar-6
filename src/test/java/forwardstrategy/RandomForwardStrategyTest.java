package forwardstrategy;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;


import domain.RandomForwardStrategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import util.generator.RandomNumberGenerator;

public class RandomForwardStrategyTest {

    @BeforeEach
    public void setUp() {
        mockStatic(RandomNumberGenerator.class);
    }

    @AfterEach
    public void tearDown() {
        Mockito.framework().clearInlineMocks();
    }

    @ParameterizedTest
    @DisplayName("랜덤 정수 전진 가능 테스트")
    @ValueSource(ints = {4,5, 6, 7, 8, 9})
    void TestCantGoNumber(int value) {
        //given
        when(RandomNumberGenerator.generateRandomNumber()).thenReturn(value);
        RandomForwardStrategy forwardStrategy = new RandomForwardStrategy();

        //then
        assertThat(forwardStrategy.canMove()).isTrue();
    }


    @ParameterizedTest
    @DisplayName("랜덤 정수 전진 불가능 가능 테스트")
    @ValueSource(ints = {1, 2, 3})
    void TestCanGoNumber(int value) {
        //given
        when(RandomNumberGenerator.generateRandomNumber()).thenReturn(value);
        RandomForwardStrategy forwardStrategy = new RandomForwardStrategy();

        //then
        assertThat(forwardStrategy.canMove()).isFalse();
    }
}
