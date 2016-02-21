import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class SortArrayByFrequence {
    class Node{
        public int count;
        public int firstIndex;
    }

    public class SortByFrequenceComparator implements Comparator<Integer>{
        public Map<Integer, Node> table;
        public SortByFrequenceComparator(Map hm){
            table = hm;
        }
        @Override
        public int compare(Integer l1, Integer l2){
            Node n1 = table.get(l1);
            Node n2 = table.get(l2);
            if(n1.count < n2.count) return 1;
            if(n1.count > n2.count) return -1;
            else
                return (n1.firstIndex < n2.firstIndex)? -1: 1;
        }
    }

    public void sortByFrequence(Integer arr[]){
        Map<Integer, Node> table = new HashMap<>();
        int count = 0;
        for(Integer x : arr){
            if(table.containsKey(x)){
                Node temp = table.get(x);
                temp.count++;
            }
            else{
                Node newNode = new Node();
                newNode.count = 1;
                newNode.firstIndex = count;
                table.put(x, newNode);
            }
            count++;
        }
        SortByFrequenceComparator sc = new SortByFrequenceComparator(table);
        Arrays.sort(arr, sc);
    }

    public static void main(String args[]){
        Integer input[] = {5,2,8,9,9,9,2};
        SortArrayByFrequence saf = new SortArrayByFrequence();
        saf.sortByFrequence(input);
        for(int i : input){
            System.out.print(i + "\t");
        }
    }
}
