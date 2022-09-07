package ru.otus.hibernate.configuration;

import ru.otus.server.WebServer;

import java.io.IOException;

public interface ServerConfiguration {
    WebServer configure() throws IOException;
}
