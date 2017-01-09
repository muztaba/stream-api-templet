import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by muztaba.hasanat on 11/14/2016.
 */
public class Main {
    public static void main(String[] args) {

        // Sorting Map on value
        Map<String, Integer> map = Util.mapInit();
        Map<String, Integer> sortedMapByValue = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //reverse order
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o, n) -> o, // For duplicate key
                        LinkedHashMap::new
                ));

        // average of a int array
        int[] a = {1, 2, 33, 44, 5, 5};
        OptionalDouble avg = Arrays.stream(a)
                .average();

        // other way
        double doubleAvg = IntStream.of(a)
                .summaryStatistics()
                .getAverage();

        // Find the department from list which average salary of employees maximum
        String  deptName = Util.nodeList().stream()
                .collect(Collectors.groupingBy(Node::getDept, Collectors.averagingDouble(Node::getSalary)))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }
}

class Util {
    static Map<String, Integer> mapInit() {
        return Stream.of("1 SEAL", "5 HASANAT", "3 MUZTABA", "2 PJ")
                .map(i -> i.split(" "))
                .collect(Collectors.toMap((i -> i[1]), i -> Integer.parseInt(i[0])));
    }

    static List<Node> nodeList() {
        return Arrays.asList(new Node("A", "CSE", 5500),
                new Node("B", "CSE", 5600),
                new Node("C", "CSE", 4500),
                new Node("D", "EEE", 7000),
                new Node("E", "EEE", 3400),
                new Node("F", "EEE", 8000),
                new Node("G", "ECO", 4000),
                new Node("H", "ECO", 5000),
                new Node("I", "ECO", 7000));

    }
}


class Node {
    String name;
    String dept;
    int salary;

    public Node(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }
}