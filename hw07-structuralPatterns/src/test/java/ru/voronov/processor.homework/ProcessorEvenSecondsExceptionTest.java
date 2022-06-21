package ru.voronov.processor.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.voronov.processor.Processor;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Aleksandr Voronov
 */
public class ProcessorEvenSecondsExceptionTest {

    @Test
    @DisplayName("Тестируем вызов процессора ProcessorEvenSecondsException в нечетную секунду")
    public void atOddSecond(){
        Processor processor = new ProcessorEvenSecondsException(
                () -> LocalDateTime.of(2022, Month.JUNE, 18, 19,19, 21)
        );
        assertDoesNotThrow(() -> processor.process(null));
    }

    @Test
    @DisplayName("Тестируем вызов процессора ProcessorEvenSecondsException в четную секунду")
    public void atEvenSecond(){
        Processor processor = new ProcessorEvenSecondsException(
                () -> LocalDateTime.of(2022, Month.JUNE, 18, 19,19, 20)
        );
        assertThrows(InvalidSecondException.class, () -> processor.process(null));
    }

}
