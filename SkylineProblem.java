package Package2;

import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]});  
        }

        events.sort((a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); 

        int prevMax = 0;
        for (int[] event : events) {
            if (event[1] < 0) {
                maxHeap.add(-event[1]); 
            } else {
                maxHeap.remove(event[1]); 
            }

            int currMax = maxHeap.peek();
            if (currMax != prevMax) {
                result.add(Arrays.asList(event[0], currMax));
                prevMax = currMax;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SkylineProblem sp = new SkylineProblem();
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings2 = {{0, 2, 3}, {2, 5, 3}};

        System.out.println(sp.getSkyline(buildings1));
        System.out.println(sp.getSkyline(buildings2));
    }
}
