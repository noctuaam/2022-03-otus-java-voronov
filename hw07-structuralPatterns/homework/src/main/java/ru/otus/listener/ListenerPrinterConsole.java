package ru.otus.listener;

import ru.otus.model.Message;

public class ListenerPrinterConsole implements ru.otus.listener.Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:%s", msg);
        System.out.println(logString);
    }
}
