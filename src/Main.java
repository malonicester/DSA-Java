import jdk.dynalink.beans.StaticClass;

public class Main {
    public static void main(String[] args) {
//        toh(3, 10, 11, 12);

//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        print(4);
//        printArray(0,0,arr,0);
//        print2dArray(3, 3, arr, 0);
//        int[] arr1 = {1, 2, 3, 4, 5};
//        StringBuilder sb = new StringBuilder();
//        System.out.println(arrayToString(0, arr1, sb));
//        long ans = factorial(10);
//        System.out.println(ans);
//        printOddSumInCol1(arr, 0, 0, 0);
//        printEvenSum(arr, 0, 0, 0);
//        System.out.println(fibonacci(0));
    }

    static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0) {
            return;
        }
        toh(n - 1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + "->" + t2id + "]");
        toh(n - 1, t3id, t2id, t1id);
    }

    public StringBuilder sb;

    static void printArray(int n, int[] arr) {
        if (n == 0) {
            return;

        }
        printArray(n - 1, arr);
        System.out.println(arr[n - 1] + " ");
    }

    static void printArray(int n, int m, int[][] arr, int sum) {
        if (m == arr[0].length) {
            System.out.println(sum);
            sum = 0;
            n = n + 1;
            m = 0;
        }
        if (n == arr.length) {
            return;
        }
        if (arr[n][m] % 2 == 0) sum += arr[n][m];
        printArray(n, m + 1, arr, sum);
    }

    static void print2dArray(int n, int m, int[][] arr, int sum) {
        if (m == 0) {
            m = arr[n - 1].length;
            n = n - 1;
        }
        if (n == 0) {
            return;
        }
        print2dArray(n, m - 1, arr, 0);
        System.out.print(arr[n - 1][m - 1] + " ");
        sum += arr[n - 1][m - 1];
        System.out.println(sum);
    }

    static String arrayToString(int n, int[] arr, StringBuilder sb) {
        if (n == arr.length) {
            return sb.toString();
        }
        sb.append(arr[n]);
        return arrayToString(n + 1, arr, sb);
    }

    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long ans = n * factorial(n - 1);
        System.out.println(n);
        return ans;
    }

    static void printOddSumInCol(int[][] arr, int n, int m, int sum) {
        if (n == 0) {
            System.out.println(sum);
            sum = 0;
            m = m - 1;
            n = arr.length;
        }
        if (m == 0) {
            return;
        }
        if (arr[n - 1][m - 1] % 2 == 1) {
            sum += arr[n - 1][m - 1];
        }
        printOddSumInCol(arr, n - 1, m, sum);
    }

    static void printOddSumInCol1(int[][] arr, int n, int m, int sum) {
        if (n == arr.length) {
            System.out.println(sum);
            sum = 0;
            m = m + 1;
            n = 0;
        }
        if (m == arr[0].length) {
            return;
        } else if (arr[n][m] % 2 == 1) {
            sum += arr[n][m];
        }
        printOddSumInCol1(arr, n + 1, m, sum);

    }

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static void printEvenSum(int[][] arr, int n, int m, int sum) {
        if (m == arr[0].length) {
            System.out.println(sum);
            sum = 0;
            m = 0;
            n = n + 1;
        }
        if (n == arr.length) {
            return;
        }
        if (arr[n][m] % 2 == 0) sum += arr[n][m];
        printEvenSum(arr, n, m + 1, sum);
    }

    static void print(int n) {
        int f1 = 0, f2 = 1, i;
        System.out.print(f1 + " ");
        if (n < 1)
            return;

        for (i = 1; i < n; i++) {
            System.out.print(f2 + " ");
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
    }
}
