package homework;

import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    LinkedList<Customer> linkedList = new LinkedList<>();

    public void add(Customer customer) {
        linkedList.add(customer);
    }

    public Customer take() {
        return linkedList.pollLast();

    }
}
