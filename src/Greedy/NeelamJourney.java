package Greedy;

public class NeelamJourney {
    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 3, 4};
        int ans = neelamJourney(arr);
        System.out.println(ans);
    }

    static int neelamJourney(int[] arr) {
        int totalCost = 0;
        int board = 0;
        for (int i = 0; i < arr.length; i++) {
//           if we found a location where boarding cost is less than current location
//           We would update that location and calculate the cost accordingly
            if (arr[board] > arr[i]) {
                totalCost += (i - board) * arr[board];
                board = i;
            }
        }
        totalCost += (arr.length - board) * arr[board];
        return totalCost;
    }
}
