package ru.otus.hibernate.configuration;

import ru.otus.hibernate.service.DBServiceClient;
import ru.otus.server.WebServer;
import ru.otus.server.WebServerImpl;
import ru.otus.services.TemplateProcessor;
import ru.otus.services.TemplateProcessorImpl;
import ru.otus.services.UserAuthService;
import ru.otus.services.UserAuthServiceImpl;

import java.io.IOException;

public class ServerConfigurationBasic implements ServerConfiguration {

    private static final int WEB_SERVER_PORT = 8080;
    private static final String TEMPLATES_DIR = "/templates/";
    private final DBServiceClient dbServiceClient;

    public ServerConfigurationBasic(DBServiceClient dbServiceClient) {
        this.dbServiceClient = dbServiceClient;
    }

    @Override
    public WebServer configure() throws IOException {
        TemplateProcessor templateProcessor = new TemplateProcessorImpl(TEMPLATES_DIR);
        UserAuthService userAuthService = new UserAuthServiceImpl(dbServiceClient);

        return new WebServerImpl(WEB_SERVER_PORT, templateProcessor, userAuthService, dbServiceClient);
    }
}

