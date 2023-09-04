package Faang;

public class Leetcode287 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,1};
        System.out.println(findDuplicate(arr));
    }
     public static int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
             slow = nums[slow];
             fast = nums[nums[fast]];
             }
            slow = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }

}




