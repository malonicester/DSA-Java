package Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] weight = {10, 30, 20, 50};
        int[] values = {40, 30, 80, 70};
        fractionalKnapsack(weight, values, 60);
    }

    static void fractionalKnapsack(int[] weight, int[] values, int capacity) {
        float[][] costPerUnitWeight = new float[weight.length][3];
        for (int i = 0; i < weight.length; i++) {
            costPerUnitWeight[i][0] = (float) values[i] / weight[i];
            costPerUnitWeight[i][1] = values[i];
            costPerUnitWeight[i][2] = weight[i];
        }
        Arrays.sort(costPerUnitWeight, (a, b) -> (int) (a[0] - b[0]));
        for (float[] arr : costPerUnitWeight)
            System.out.println(Arrays.toString(arr));
    }
}
