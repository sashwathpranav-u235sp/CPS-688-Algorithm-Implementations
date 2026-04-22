import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LIS {

    public static List<Integer> findLIS(List<Integer> nums) {
        if (nums.isEmpty()) {
            return new ArrayList<>();
        }

        int n = nums.size();
        int[] dp = new int[n];
        int[] prev = new int[n];

        // Initialize DP arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (nums.get(j) < nums.get(i) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        // Find the maximum length and its index
        int maxLength = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the LIS
        List<Integer> lis = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            lis.add(0, nums.get(current));
            current = prev[current];
        }

        return lis;
    }
}