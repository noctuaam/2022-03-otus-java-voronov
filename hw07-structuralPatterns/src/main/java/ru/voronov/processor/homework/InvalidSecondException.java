package ru.voronov.processor.homework;

/**
 * @author Aleksandr Voronov
 */
public class InvalidSecondException extends RuntimeException{

    InvalidSecondException(String message){
        super(message);
    }
}
