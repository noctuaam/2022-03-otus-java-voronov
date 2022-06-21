package ru.voronov.listener;

import ru.voronov.model.Message;

public class ListenerPrinterConsole implements ru.voronov.listener.Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:%s", msg);
        System.out.println(logString);
    }
}
