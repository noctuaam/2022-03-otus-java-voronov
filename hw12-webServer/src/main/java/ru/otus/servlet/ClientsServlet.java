package ru.otus.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.otus.helpers.ClientMappingHelper;
import ru.otus.hibernate.service.DBServiceClient;
import ru.otus.services.TemplateProcessor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;


public class ClientsServlet extends HttpServlet {

    private static final String USERS_PAGE_TEMPLATE = "clients.html";
    private static final String TEMPLATE_ATTR_CLIENTS_LIST = "clientsList";
    private final DBServiceClient dbServiceClient;
    private final ClientMappingHelper clientMappingHelper = new ClientMappingHelper();

    private final TemplateProcessor templateProcessor;

    public ClientsServlet(TemplateProcessor templateProcessor, DBServiceClient dbServiceClient) {
        this.templateProcessor = templateProcessor;
        this.dbServiceClient = dbServiceClient;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Map<String, Object> clientMap = new HashMap<>();

        clientMap.put("clients", dbServiceClient.findAll()
                .stream()
                .map(clientMappingHelper::mapToTemplateData)
                .collect(toList()));
        response.setContentType("text/html");
        response.getWriter().println(templateProcessor.getPage("clients.html", clientMap));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        dbServiceClient.saveClient(clientMappingHelper.mapToInstance(req));
        response.sendRedirect(req.getServletPath());
    }

}
