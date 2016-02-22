package Array;

import java.util.Set;
import java.util.HashSet;

/**
 * http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
 */
public class CheckIfArrayElementsAreConsecutive {
    //satisfy two conditions
    //    1) max – min + 1 = n where max is the maximum element in array,
    //       min is minimum element in array and n is the number of elements in array.
    //    2) All elements are distinct.
    public boolean areConsecutive(int input[]){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> num = new HashSet<>();
        for(int i=0; i < input.length; i++){
            if(input[i] < min)
                min = input[i];
            if(input[i] > max)
                max = input[i];
            if(!num.contains(input[i])) num.add(input[i]);
        }
        if((max - min + 1) == input.length && num.size() == input.length) return true;
        return false;
    }
    
    public static void main(String args[]){
        int input[] = {75,78,76,77,73,74};
        CheckIfArrayElementsAreConsecutive cia = new CheckIfArrayElementsAreConsecutive();
        System.out.println(cia.areConsecutive(input));
    }
}
