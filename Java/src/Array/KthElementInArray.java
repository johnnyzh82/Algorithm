package Array;

/**
 * Kth largest element in an array.
 * Use quickselect of quicksort to find the solution in hopefully O(nlogn) time.
 * Test cases
 * Sorted array
 * Reverse sorted array
 */
public class KthElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length) return 0;
        int start = 0;
        int end = nums.length - 1;
        return quickSelect(nums, start, end, nums.length - k);
    }

    public int quickSelect(int[] array, int start, int end, int k){
        int pivot = array[end];
        int left = start;
        int right = end - 1;

        while(true){
            while(array[left] < pivot && left < right) left++;
            while(array[right] >= pivot && left < right) right--;
            if(left == right) break;
            swap(array, left, right);
        }

        swap(array, left, end);

        if(left == k){
            return pivot;
        } else if(left < k){
            return quickSelect(array, left + 1, end, k);
        } else {
            return quickSelect(array, start, left - 1, k);
        }
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String args[]){
        int arr[] = {3,2,1,5,6, 4};
        KthElementInArray kthElement = new KthElementInArray();
        System.out.println("\nKth largest number is " + kthElement.findKthLargest(arr, 2));
    }
    
}
