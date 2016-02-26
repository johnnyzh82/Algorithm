package Sort;

/**
 * Date 04/03/2015
 * @author tusroy
 * 
 * Heap Sort
 * Given an array sort it using heap sort
 * 
 * Solution :
 * First convert the original array to create the heap out of the array
 * Then move the max element to last position and do heapify to recreate the heap
 * with rest of the array element. Repeat this process
 * 
 * Time complexity
 * O(nlogn)
 *
 */
public class HeapSort {
    // parent   -------------> left child : right child
    // n        -------------> 2n + 1     : 2n + 2
    // | n - 1 |
    // | ----- |-------------> n
    // |__ 2 __|
    public void sort(int arr[]){
        //init with only 1 element arr[0], which is heap with 1 element
        for(int i=1; i < arr.length; i++){
            heapAdd(arr, i);
        }
        
        for(int i = arr.length-1; i > 0 ; i--){
            swap(arr, 0, i);
            reheapify(arr, i-1);
        }
    }

    //when poll node from heap, we must reheapify the rest array.
    //1, first get last element in array
    //2, swap it with first element in heap
    //3, if it's larger than both children, then break;
    //4, if it's smaller, then swap with Max(left, right) until reach end
    //notice: when heap w/o a right child, heap is self-balanced tree, all leaf node are located as left as possible
    private void reheapify(int arr[], int end){
        int i = 0;
        int leftIndex;
        int rightIndex;
        while(i <= end){
            leftIndex = 2*i + 1;
            if(leftIndex > end){
                break;
            }
            rightIndex = 2*i + 2;
            if(rightIndex > end){
                rightIndex = leftIndex;
            }
            if(arr[i] >= Math.max(arr[leftIndex], arr[rightIndex])){
                break;
            }
            if(arr[leftIndex] >= arr[rightIndex]){
                swap(arr, i, leftIndex);
                i = leftIndex;
            }else{
                swap(arr, i, rightIndex);
                i = rightIndex;
            }
        }
    }
    
    private void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    private void heapAdd(int arr[], int end){
        int i = end;
        while(i > 0){
            //compare this element with its parent, if it's greater then swap
            if(arr[i] > arr[(i-1)/2]){
                swap(arr, i, (i-1)/2);
                i = (i - 1)/2;
            } else {
                break;
            }
        }
    }
    
    public static void main(String args[]){
        HeapSort hs = new HeapSort();
        int arr[] = {-1,5,8,2,-6,-8,11,5};
        hs.sort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }
}
