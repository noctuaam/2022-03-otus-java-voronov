package ru.voronov.processor.homework;

import ru.voronov.model.Message;
import ru.voronov.processor.Processor;

/**
 * @author Aleksandr Voronov
 */
public class ProcessorSwapField11Field12 implements Processor {

    @Override
    public Message process(Message message) {
        return message.toBuilder().field11(message.getField12()).field12(message.getField11()).build();
    }
}
