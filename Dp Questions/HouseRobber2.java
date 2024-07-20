// https://leetcode.com/problems/house-robber-ii/

public class HouseRobber2{

    public static void main(String[] args) {
        int[] nums = { 1 , 2 , 3 , 1 };
        int answer = rob(nums);
        System.out.println(answer);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(solveDp(nums , 0 , nums.length - 1), solveDp(nums , 1 , nums.length));
    }
    

    public static int solveDp(int[] nums , int start , int end){
        int prev = 0 , prev2 = 0;

        for(int i = start; i < end; i++){
            int curr = Math.max(nums[i] + prev2 , prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}