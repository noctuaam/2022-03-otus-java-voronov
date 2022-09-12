package ru.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
    Полезные для демо ссылки

    // Стартовая страница
    http://localhost:8080

    // Страница клиентов
    http://localhost:8080/clients

*/
@SpringBootApplication
public class SpringAppDemo {

    public static void main(String[] args){
        SpringApplication.run(SpringAppDemo.class, args);
    }
}
