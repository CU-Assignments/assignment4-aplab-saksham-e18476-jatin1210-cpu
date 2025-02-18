package Package2;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {
    public static int[] beautifulArray(int n) {
        List<Integer> result = constructBeautifulArray(n);
        int[] beautifulArr = new int[n];
        for (int i = 0; i < n; i++) {
            beautifulArr[i] = result.get(i);
        }
        return beautifulArr;
    }

    private static List<Integer> constructBeautifulArray(int n) {
        if (n == 1) {
            List<Integer> baseCase = new ArrayList<>();
            baseCase.add(1);
            return baseCase;
        }

        List<Integer> odd = new ArrayList<>();
        for (int num : constructBeautifulArray((n + 1) / 2)) {
            odd.add(2 * num - 1); 
        }

        List<Integer> even = new ArrayList<>();
        for (int num : constructBeautifulArray(n / 2)) {
            even.add(2 * num);
        }

        odd.addAll(even);
        return odd;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 5;

        int[] result1 = beautifulArray(n1);
        int[] result2 = beautifulArray(n2);

        System.out.println("Beautiful Array for n = " + n1 + ": " + java.util.Arrays.toString(result1));
        System.out.println("Beautiful Array for n = " + n2 + ": " + java.util.Arrays.toString(result2));
    }
}
