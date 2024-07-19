// https://www.geeksforgeeks.org/problems/introduction-to-dp/1

public class Fibonacci{
    public static void main(String[] args) {
        int n = 5;
        long answer1 = Solution.topDown(n);
        long answer2 = Solution.bottomUp(n);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    static class Solution{
        static int MOD = 1000000007;
    
        static long topDown(int n){
            long[] dp = new long[n + 1];
            return topDownHelper(n, dp);
        }
    
        static long topDownHelper(int n , long[] dp){
            if (n <= 1) return n;
            if (dp[n] != 0) return dp[n];
    
            return dp[n] = (topDownHelper(n - 1, dp) + topDownHelper(n - 2, dp)) % MOD;
        }
    
        static long bottomUp(int n){
    
            long prev1 = 0L , prev2 = 1L , curr = 1L;
    
            for(int i = 2 ; i <= n ; i++){
                curr = (prev1 + prev2) % MOD;
                prev1 = prev2;
                prev2 = curr;
            }
            return curr;
        }
    }
}