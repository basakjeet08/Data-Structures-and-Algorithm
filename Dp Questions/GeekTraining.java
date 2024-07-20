// https://www.geeksforgeeks.org/problems/geeks-training/1


public class GeekTraining {
    public static void main(String[] args) {
        int n = 3;
        int[][] points = {
                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 }
        };

        int answer = maximumPoints(points, n);
        System.out.println(answer);
    }

    public static int maximumPoints(int[][] points, int N) {

        // // Memoization Call
        // int[][] dp = new int[N][3];

        // int answer = Integer.MIN_VALUE;
        // for(int i = 0 ; i < points[0].length ; i++)
        // answer = Math.max(answer , maximumPointsMemoization(points, N - 1, i , dp));

        int answer = maximumPointsTabulation(points, N);
        return answer;
    }

    // Memoization Solution.
    public static int maximumPointsMemoization(int[][] points, int day, int previousCol, int[][] dp) {
        if (day < 0)
            return 0;
        if (dp[day][previousCol] != 0)
            return dp[day][previousCol];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            if (i == previousCol)
                continue;

            int child = maximumPointsMemoization(points, day - 1, i, dp);
            max = Math.max(max, child + points[day][i]);
        }

        return dp[day][previousCol] = max;
    }

    // Tabulation Process
    private static int maximumPointsTabulation(int[][] points, int N) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[N][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < N; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[N - 1][3];
    }
}
