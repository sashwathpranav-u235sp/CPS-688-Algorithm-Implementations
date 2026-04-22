import java.util.Scanner;

public class Knapsack {

    public static int knapsack(int W, int[] weights, int[] values, int N) {
        int[][] dp = new int[N + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[N][W];
    }
}
