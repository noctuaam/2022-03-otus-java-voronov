package homework;

import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    TreeMap<Customer,String> customerStringMap = new TreeMap<>();
    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry entry = customerStringMap.firstEntry();
        if(entry == null) return null;
        return new AbstractMap.SimpleEntry<>(((Customer) entry.getKey()).clone(),
                (String) entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry entry = customerStringMap.higherEntry(customer);
        if(entry == null) return null;
        return new AbstractMap.SimpleEntry<>(((Customer) entry.getKey()).clone(),
                                             (String) entry.getValue());

    }

    public void add(Customer customer, String data) {
        customerStringMap.put(customer,data);
    }
}
