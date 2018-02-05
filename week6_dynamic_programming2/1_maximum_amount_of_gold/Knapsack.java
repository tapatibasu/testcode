import java.util.*;

class Optimal {
    int [][] dp;
    int W;
    int[] w;
    Optimal(int WW, int[] ww)
    {
       W = WW;
       w = Arrays.copyOfRange(ww, 0, ww.length);
       dp = new int[w.length + 1][W+1];

    }
    int optW()
    {
              for (int i = 1; i < w.length + 1; i++) 
              {
                 for (int j = 1; j <= W; j++) 
                 {
                    if (w[i-1] > W) { dp[i][j] = dp[i-1][j]; continue; }
                    int prev = dp[i-1][j];
                    int cur = 0; 
                    if (w[i-1] <= j) 
                    {
                    	cur = dp[i-1][j - w[i-1]] + w[i-1];
                    }
                    dp[i][j] = Math.max(prev, cur); 
                 } 
              }
              return dp[w.length][W];
    }
}

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        return new Optimal(W, w).optW();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

