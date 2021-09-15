// Time Complexity : O(log n)
// Space Complexity : O(1)

public class BinarySearch{
    // Returns the index of the searched element
    public static int search(int[] nums, int target) {
        // start index - 1st pointer
        int start=0;
        // end index - 2nd pointer
        int end=nums.length-1;
        // iterate over the array elements
        // by moving the pointers to the corresponding index
        while(start<=end){
            // calculate mid index
            int mid=start+(end-start)/2;
            // check if mid element is less than the searched element
            if(nums[mid]<target){
                // move the start pointer one position to the right of mid index
                start=mid+1;
            }
            if(nums[mid]>target){
                // move the end pointer one position to the left of mid index
                end=mid-1;
            }
            // if mid element is the searched element of
            // return the mid index
            if(nums[mid]==target){
                return mid;
            }
        }
        // no matches found in the array
       return -1; 
    }

    public static void main(String[] args) throws Exception{

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("The index of the searched element is " + search(nums, target));

    }

}