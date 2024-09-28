package sheetSolutions.searchSort;

import java.util.Arrays;

public class searchInRotatedArray {

  // Complete this function
    public static int searchBS(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        int mid = -1, prevEle = 0, nextEle = 0;
        int minIndex =0;
      // Array already sorted
        if(nums[start]<=nums[end]){
            return binarySearch(nums,0,end,target);
        }
        while(start<=end){
            mid = (start+end)/2;
            prevEle = (mid+nums.length -1)%nums.length;
            nextEle = (mid+1)%nums.length;
            if(nums[mid] <= nums[prevEle] && nums[mid]<= nums[nextEle]){
                minIndex = mid;
                break;
            }
            else if(nums[0]<=nums[mid]){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
          
          if(target>=nums[0]){
           return  binarySearch(nums, 0, minIndex -1, target);
          }
          else{
             return binarySearch(nums, minIndex,nums.length -1, target);
          }
    }

    public int binarySearch(int[] arr , int low, int high, int target){
        int mid = 0;
        while(low<=high){
             mid = low+(high -low)/2;
            if(arr[mid]== target){
                return mid;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }

  
  static int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // First step is to find the pivot where the
    // array is rotated
    while (left < right) {
      int mid = left + (right - left) / 2;
      // If the element at the mid is greater than
      // the element at the right then we can say that
      // the array is rotated after middle index i.e the min element is in the right of mid
      if (nums[mid] > nums[right]) left = mid + 1;
      else right = mid; // Else, the pivot is in the left part
    }

    // After the above loop is completed, then the
    // left index will point to the pivot
    int pivot = left;
    left = 0;
    right = nums.length - 1;

    // Now we will find in which half of the array,
    // our target is present
    if (target >= nums[pivot] && target <= nums[right]) left = pivot;
    else right = pivot;
    // Now perform normal binary search
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (target == nums[middle]) return middle;
      else if (target < nums[middle]) right = middle - 1;
      else left = middle + 1;
    }
    return -1;
  }

  public static int findElementRecursive(int[] input, int start, int end, int key) {

    if (start <= end) {
      int mid = start + (end - start) / 2;

      if (input[mid] == key) return mid;
      else if (input[start] <= input[mid]) {
        /*Left sub array is sorted, check if
        key is with A[start] and A[mid] */
        if (input[start] <= key && input[mid] > key) {
          /*
           Key lies with left sorted part of array
          */
          return findElementRecursive(input, start, mid - 1, key);
        } else {
          /*
          Key lies in right subarray
           */
          return findElementRecursive(input, mid + 1, end, key);
        }
      } else {
        /*
        In this case, right subarray is already sorted and
        check if key falls in range A[mid+1] and A[end]
        */
        if (input[mid + 1] <= key && input[end] > key) {
          /*
           Key lies with right sorted part of array
          */
          return findElementRecursive(input, mid + 1, end, key);
        } else {
          /*
          Key lies in left subarray
           */
          return findElementRecursive(input, start, mid - 1, key);
        }
      }
    }
    return -1;
  }

  public static int findElementIterative(int[] input, int start, int end, int key) {

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (input[mid] == key) return mid;
      else if (input[start] <= input[mid]) {
        /*Left sub array is sorted, check if
        key is with A[start] and A[mid] */
        if (input[start] <= key && input[mid] > key) {
          /*
           Key lies with left sorted part of array
          */
          end = mid - 1;
        } else {
          /*
          Key lies in right subarray
           */
          start = mid + 1;
        }
      } else {
        /*
        In this case, right subarray is already sorted and
        check if key falls in range A[mid+1] and A[end]
        */
        if (input[mid + 1] <= key && input[end] > key) {
          /*
           Key lies with right sorted part of array
          */
          start = mid + 1;
        } else {
          /*
          Key lies in left subarray
           */
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] ar = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(Arrays.toString(ar));
    System.out.println(search(ar, 1));
  }
}
