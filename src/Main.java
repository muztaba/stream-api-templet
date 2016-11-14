import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
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
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o, n) -> o, // For duplicate key
                        LinkedHashMap::new
                ));
    }
}

class Util {
    static Map<String, Integer> mapInit() {
        return Stream.of("1 SEAL", "5 HASANAT", "3 MUZTABA", "2 PJ")
                .map(i -> i.split(" "))
                .collect(Collectors.toMap((i -> i[1]), i -> Integer.parseInt(i[0])));
    }
}