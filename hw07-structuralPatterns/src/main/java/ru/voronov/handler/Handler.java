package ru.voronov.handler;

import ru.voronov.model.Message;
import ru.voronov.listener.Listener;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
