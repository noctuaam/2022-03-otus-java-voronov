package ru.voronov.processor.homework;

import ru.voronov.model.Message;
import ru.voronov.processor.Processor;

/**
 * @author Aleksandr Voronov
 */
public class ProcessorEvenSecondsException implements Processor {

    private final TimeProvider timeProvider;

    public ProcessorEvenSecondsException(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public Message process(Message message) {
        var second = timeProvider.getTime().getSecond();
        if (second % 2 == 0) {
            throw new InvalidSecondException("It's an even second: " + second);
        }
        return message;
    }
}
