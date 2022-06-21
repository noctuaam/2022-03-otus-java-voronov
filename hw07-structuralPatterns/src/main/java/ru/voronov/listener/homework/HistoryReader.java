package ru.voronov.listener.homework;

import ru.voronov.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}
