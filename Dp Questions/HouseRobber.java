
// https://leetcode.com/problems/house-robber/description/

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = { 2 , 7 , 9 , 3 , 1 };
        int answer = rob(nums);
        System.out.println(answer);
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0] , nums[1]);
        if(nums.length == 3) return Math.max(nums[0] + nums[2] , nums[1]);

        int thirdPrev = nums[0];
        int secondPrev = nums[1];
        int prev = nums[0] + nums[2];

        for(int i = 3 ; i < nums.length ; i++){
            int curr = Math.max(secondPrev , thirdPrev) + nums[i];

            thirdPrev = secondPrev;
            secondPrev = prev;
            prev = curr;
        }

        return Math.max(prev , secondPrev);
    }    
}
