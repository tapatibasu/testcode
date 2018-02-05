import java.util.*;

class Calc {
   public List<Integer> s ; 
   public int [] dp;
   int n; 
   Calc(int num) { n = num; s = new ArrayList<Integer>(); dp = new int[n+1];}
   public List<Integer> optimal()
   {
      if (n == 0) return s;
      dp[0] = 0; 
      int i = 1;
     
      while (i <= n)
      {
          if (i == 1)  {dp[1] = 1; s.add(1);}
            
          else {
              int op1 = Integer.MAX_VALUE;
              int op2 = Integer.MAX_VALUE; 
              int op3 = Integer.MAX_VALUE; 
              if ( i % 4 == 0) {
                  op1 = dp[i/4] + 1;
              }
              else if ( i % 3 == 0) { 
                  op2 = dp[i/3] + 1;
              }
              else {
                  op3 = dp[i-1] + 1;
              }
              dp[i] = Integer.min(op1, Integer.min(op2, op3));
              if (op1 == dp[i]) s.add(i/4);
              else if (op2 == dp[i]) s.add(i/3);
              else s.add(i-1);
          }
          i++;
      }
      return s;

   }
}

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new Calc(n).optimal();
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

