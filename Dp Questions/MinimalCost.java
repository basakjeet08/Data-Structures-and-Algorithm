// https://www.geeksforgeeks.org/problems/minimal-cost/1

import java.util.Arrays;

public class MinimalCost {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] heights = {10, 30, 40, 50, 20};
        int answer = minimizeCost(heights, N, K);

        System.out.println(answer);
    }

    public static int minimizeCost(int[] heights , int N , int K){
        
        // Memoization Solution.
        // int[] dp = new int[N];
        // return minimizeMemoization(heights, N - 1, K, dp);

    
        // Tabulation Solution.
        return minimizeTabulation(heights, N, K);
    }


    // Memoization Solution.
    public static int minimizeMemoization(int[] heights , int N , int K , int[] dp){
        if(N <= 1) return Math.abs(heights[0] - heights[N]);
        if(dp[N] != 0) return dp[N];

        int minCost = Integer.MAX_VALUE;
        int i = Math.max(N - K , 0);
        for(; i < N ; i++){
            int childCost = Math.abs(heights[i] - heights[N]) + minimizeMemoization(heights, i, K, dp);
            minCost = Math.min(minCost, childCost);
        }

        return dp[N] = minCost;
    }


    // Tabulation Method.
    public static int minimizeTabulation(int[] heights , int N , int K){
        int[] dp = new int[N];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0 ; i < N ; i++)
            for(int k = i + 1 ; k <= i + K && k < N; k++){
                int costTillHere = dp[i] + Math.abs(heights[i] - heights[k]);
                dp[k] = Math.min(dp[k] , costTillHere);
            }
        return dp[N - 1];
    }
}