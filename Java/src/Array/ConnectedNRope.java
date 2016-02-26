package Array;
import java.util.PriorityQueue;

/**
 * Created by yunlong on 2/25/16.
 */
public class ConnectedNRope {
    public int calculateMinimum(int [] array){
        if(array == null || array.length == 0) return 0;
        //lambda expression to replace anonymous comparator.
        //Min-heap: (Integer o1, Integer o2) -> o1 - o2
        //Max-heap: (Integer o1, Integer o2) -> o2 - O1
        //priority queue default is min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(array.length);
        for(int num : array)
            heap.add(num);
        //add a integer to track sum
        int result = 0;
        while (heap.size() > 1){
            int firstMin = heap.poll();
            int secondMin = heap.poll();
            heap.add(firstMin + secondMin);
            result += (firstMin + secondMin);
        }
        return result;
    }

    public static void main(String [] args){
        int [] array = {4, 3, 2, 6};
        ConnectedNRope cr = new ConnectedNRope();
        System.out.println("Min cost is " + cr.calculateMinimum(array));
    }
}