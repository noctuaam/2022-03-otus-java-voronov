package ru.otus.cachehw;

/**
 * @author Aleksandr Voronov
 */
public enum MyCacheAction{
    PUT("Объект добавлен в кэш"),
    GET("Объект получен из кэша"),
    REMOVE("Объект удален из кэша");

    public final String title;

    MyCacheAction(String title) {
        this.title = title;
    }
}
