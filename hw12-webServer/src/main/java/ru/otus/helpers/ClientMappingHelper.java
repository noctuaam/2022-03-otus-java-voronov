package ru.otus.helpers;

import jakarta.servlet.http.HttpServletRequest;
import ru.otus.hibernate.model.Address;
import ru.otus.hibernate.model.Client;
import ru.otus.hibernate.model.Phone;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClientMappingHelper {
    public Map<String, Object> mapToTemplateData(Client client) {
        if (isNull(client)) {
            return null;
        } else {

            var phones = isNull(client.getPhones()) ? "" :
                    client.getPhones()
                            .stream()
                            .map(Phone::getNumber)
                            .collect(joining(","));

            Map<String, Object> res =
            Map.of("id", nonNull(client.getId()) ? client.getId() : "",
                    "name", nonNull(client.getName()) ? client.getName() : "",
                    "login", nonNull(client.getLogin()) ? client.getLogin() : "",
                    "password", nonNull(client.getPassword()) ? client.getPassword() : "",
                    "address", nonNull(client.getAddress()) ? client.getAddress().getStreet() : "",
                    "phones", isNull(client.getPhones()) ? "" :
                                client.getPhones()
                                    .stream()
                                    .map(Phone::getNumber)
                                    .collect(joining(",")));
            return res;
        }
    }

    public Client mapToInstance(HttpServletRequest request) {
        Client instance = new Client();

        instance.setName(request.getParameter("name"));
        instance.setLogin(request.getParameter("login"));
        var address = request.getParameter("address");
        instance.setAddress(nonNull(address) ? new Address(null, address) : null);
        var phones = request.getParameter("phone");
        if (nonNull(phones)) {
            instance.setPhones(
                    stream(phones.split(","))
                    .map(phone -> new Phone(null, phone, instance))
                    .collect(toList()));
        }
        return instance;
    }
}
