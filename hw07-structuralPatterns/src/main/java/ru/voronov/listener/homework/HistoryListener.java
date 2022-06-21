package ru.voronov.listener.homework;

import ru.voronov.listener.Listener;
import ru.voronov.model.Message;

import java.util.*;

public class HistoryListener implements Listener, HistoryReader {

    private final List<Message> messages;

    public HistoryListener(){
        this.messages = new ArrayList();
    }

    @Override
    public void onUpdated(Message msg) {
        messages.add((Message) msg.clone());
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(
                messages.stream()
                        .filter(message -> (new Message.Builder(id).build()).equals(message))
                        .findAny()
                        .orElse(null));
    }

}
