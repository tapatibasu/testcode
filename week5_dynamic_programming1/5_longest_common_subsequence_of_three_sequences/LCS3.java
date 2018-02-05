import java.util.*;
class Seq {
     int [] aa;
     int [] bb;
     int [] cc;
     int [][][] dp;
     Seq(int [] a, int[]b, int[] c)
     {
         aa = Arrays.copyOfRange(a, 0, a.length);
         bb = Arrays.copyOfRange(b, 0, b.length);
         cc = Arrays.copyOfRange(c, 0, c.length);
         dp = new int [aa.length + 1][bb.length + 1][cc.length + 1];
         for (int i = 0; i<= aa.length; i++) 
         {
             for (int j = 0; j <= bb.length; j++)
               dp[i][j][0] = 0; 
         }
         for (int i = 0; i<= bb.length; i++) 
         {
             for (int j = 0; j <= cc.length; j++)
               dp[0][i][j] = 0; 
         }
         for (int i = 0; i<= aa.length; i++) 
         {
             for (int j = 0; j<= cc.length; j++) 
                 dp[i][0][j] = 0; 
         }
     }
     public int lcs3()
     {
        for (int i = 1; i<= aa.length; i++)
        {
            for (int j = 1; j<= bb.length; j++)
            {
                for (int k = 1; k <= cc.length; k++)
                {
                   if ((aa[i-1] == bb[j-1]) && (aa[i-1] == cc[k-1])) 
                   {
                       dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                   }
                   else 
                   {
                        int a1 = dp[i][j][k-1];
                        int a2 = dp[i][j-1][k];
                        int a3 = dp[i][j-1][k-1];
                        int a4 = dp[i-1][j][k-1];
                        int a5 = dp[i-1][j-1][k-1];
                        int a6 = dp[i-1][j-1][k];
                        int a_final = Integer.max(a1, Integer.max(a2, Integer.max(a3, Integer.max(a4, Integer.max(a5, a6)))));
                        int b1 = dp[i][j][k-1];
                        int b2 = dp[i-1][j][k];
                        int b3 = dp[i-1][j][k-1];
                        int b4 = dp[i][j-1][k-1];
                        int b5 = dp[i-1][j-1][k-1];
                        int b6 = dp[i-1][j-1][k];
                        int b_final = Integer.max(b1, Integer.max(b2, Integer.max(b3, Integer.max(b4, Integer.max(b5, b6)))));
                        int c1 = dp[i][j-1][k];
                        int c2 = dp[i][j-1][k-1];
                        int c3 = dp[i-1][j-1][k];
                        int c4 = dp[i-1][j-1][k-1];
                        int c5 = dp[i-1][j][k];
                        int c6 = dp[i-1][j][k-1];
                        int c_final = Integer.max(c1, Integer.max(c2, Integer.max(c3, Integer.max(c4, Integer.max(c5, c6)))));
                        dp[i][j][k] = Integer.max(a_final, Integer.max(b_final, c_final));
                        
           
                   }
                }
            }
        }
        return dp[aa.length][bb.length][cc.length];
     }
}

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        return Math.min(Math.min(a.length, b.length), c.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        //System.out.println(lcs3(a, b, c));
        System.out.println(new Seq(a, b, c).lcs3());
    }
}

