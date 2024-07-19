public class GeekJump {
    
    public static void main(String[] args) {
        int[] height = { 10, 20, 30, 10};
        int N = 4;
        int answer = minimumEnergy(height, N);
        System.out.println(answer);
    }

    public static int minimumEnergy(int[] height, int N){
        
        // Memorization Solution.
        // int[] dp = new int[N];
        // return minCostMemoization(height , N - 1, dp);

        // Tabulation Solution.
        return minCostTabulation(height, N);
    }
    

    // Memoization Method.
    public static int minCostMemoization(int[] height, int N , int[] dp){
        if(N <= 1) return Math.abs(height[0] - height[N]);
        if(dp[N] != 0) return dp[N];

        int oneStep = Math.abs(height[N] - height[N - 1]) + minCostMemoization(height, N - 1 , dp);
        int twoStep = Math.abs(height[N] - height[N - 2]) + minCostMemoization(height, N - 2 , dp);
        return dp[N] = Math.min(oneStep , twoStep);
    }


    // Tabulation Method.
    public static int minCostTabulation(int[] height , int N){
        if(N == 1) return 0;
        int costTwoStepPrev = 0;
        int costPrev =  Math.abs(height[0] - height[1]);

        for(int i = 2 ; i < N ; i++){
            int prevOneStep = costPrev + Math.abs(height[i] - height[i - 1]);
            int prevTwoStep = costTwoStepPrev + Math.abs(height[i] - height[i - 2]);

            costTwoStepPrev = costPrev;
            costPrev = Math.min(prevOneStep , prevTwoStep);
        }
        return costPrev;
    }
}
