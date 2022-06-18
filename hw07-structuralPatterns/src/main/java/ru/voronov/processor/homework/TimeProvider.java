package ru.voronov.processor.homework;

import java.time.LocalDateTime;

/**
 * @author Aleksandr Voronov
 */
public interface TimeProvider {
    LocalDateTime getTime();
}
