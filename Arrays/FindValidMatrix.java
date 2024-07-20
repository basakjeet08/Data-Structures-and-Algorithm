import java.util.Arrays;

// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/?envType=daily-question&envId=2024-07-20

public class FindValidMatrix {
    
    public static void main(String[] args) {
        int[] rowSum = { 5 , 7 , 10};
        int[] colSum = { 8 , 6 , 8 };

        int[][] answer = restoreMatrix(rowSum , colSum);

        for(int[] ans : answer)
            System.out.println(Arrays.toString(ans));
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        int i = 0 , j = 0;
        
        while(i < rowSum.length && j < colSum.length){
            matrix[i][j] = Math.min(rowSum[i] , colSum[j]);
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];

            if(rowSum[i] == 0) i++;
            if(colSum[j] == 0) j++;
        }

        return matrix;
    }
}