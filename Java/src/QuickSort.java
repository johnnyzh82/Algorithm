/**
 * Created by yunlong on 2/20/16.
 */
public class QuickSort {
    public void sort(int [] arr, int low, int high){
        if(arr == null || arr.length == 0) return;
        if(low >= high) return;

        int mid = (low + high)/2;
        int pivot = arr[mid];

        int i = low, j = high;
        while(i <= j){
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j)
            sort(arr, low, j);
        if(high > i)
            sort(arr, i, high);
    }

    public static void main(String [] args){
        int [] numbers = { 9, 2, 4, 7, 3, 7, 10 };
        QuickSort qs = new QuickSort();
        qs.sort(numbers, 0, numbers.length -1);
        for(int number : numbers)
            System.out.print(number + "\t");
    }
}
