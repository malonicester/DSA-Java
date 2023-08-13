package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-5,1, 2, 3, 3, 5, 6, 4, 4);
        System.out.println(list.stream().filter(i -> i >= 5).collect(Collectors.toList()));
        double avg = list.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        double avg1 = list.stream().collect(Collectors.averagingDouble(Double::valueOf));
        System.out.println(avg);
        System.out.println(avg1);
    }

}
