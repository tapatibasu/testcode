import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k = 1; 
        int candy = 0; 
        while (candy < n)
        {
           int taken = k; 
           candy = candy + k; 
           int rem = n - candy; 
           if (rem <= taken) 
           {
              taken = taken + rem; 
              candy += rem; 
           }
           summands.add(taken); 
           k = ++taken;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

