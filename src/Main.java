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
    }
}

class Util {
    static Map<String, Integer> mapInit() {
        return Stream.of("1 SEAL", "5 HASANAT", "3 MUZTABA", "2 PJ")
                .map(i -> i.split(" "))
                .collect(Collectors.toMap((i -> i[1]), i -> Integer.parseInt(i[0])));
    }
}