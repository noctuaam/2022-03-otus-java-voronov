package ru.voronov;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aleksandr Voronov
 */
public class HelloOtus {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("one", "two", "three");
        Joiner commaCharJoiner = Joiner.on(',');
        System.out.println(commaCharJoiner.join(input));
    }
}
