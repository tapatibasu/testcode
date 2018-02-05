import java.util.Scanner;

class Change {
    int[] coin = {1, 3, 4}; 
    int [] mem; 
    int m; 
    int min; 
    Change(int money) { 
         m = money;
         mem = new int[m+1];
         mem[0] = 0; 
    }
    public int getChange() 
    {
       int val = 1; 
       while ( val <= m) {
          int minCoin = 0; 
          min = Integer.MAX_VALUE;
          for (int i = 0; i <3; i++) 
          {
                if (val < coin[i]) break; 
          	minCoin = 1 + mem[val-coin[i]];
                if (minCoin < min) min = minCoin;   
          }
          mem[val] = min; 
          val++;
       }
       //for (int i = 0; i < m+1; i++)
        //   System.out.println(mem[i]);
       return mem[m];
    }
}
   

public class ChangeDP {
    
    
    private static int getChange(int m) {
       return new Change(m).getChange();        
         
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

