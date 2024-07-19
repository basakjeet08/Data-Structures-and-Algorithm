public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 6;
        Solution ob = new Solution();
        int answer = ob.climbStairs(n);
        System.out.println(answer);
    }

    static class Solution {
        public int climbStairs(int n) {
            int waysNextNext = 0;
            int waysNext = 1;
            int curr = 1;
    
            for(int i = n - 1 ; i >= 0 ; i--){
                curr = waysNextNext + waysNext;
                waysNextNext = waysNext;
                waysNext = curr;
            }
    
            return curr;
        }
    }
}
