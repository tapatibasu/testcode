import java.util.Scanner;
import java.util.*;

class Loot {
    int value; 
    int weight;
    public Loot(int v, int w) 
    {
       value = v; 
       weight = w;
    }
    public int getValue() { return value;}
    public int getWeight() { return weight;}
}

class Helper {
 class Sortbyname implements Comparator<Loot>
   {
    public int compare(Loot a, Loot b)
    {
       double u1 = (double) (a.getValue())/ (a.getWeight());
       double u2 = (double) (b.getValue())/ (b.getWeight());
       return Double.compare(u1, u2);
    }
  }
   public double getOptimalValue(int capacity,Loot[] a) {
        Arrays.sort(a, new Sortbyname());
        int w = 0; 
        double value = 0; 
        for ( int i = a.length - 1; i>= 0; i--)
        {
            if (a[i].getWeight() + w < capacity) {
                w += a[i].getWeight();
                value += a[i].getValue();
            } 
            else 
            {
            	int rem = capacity - w; 
                double remValue = rem * (double) (a[i].getValue()/ (double)a[i].getWeight());
                value += remValue; 
                break; 
            }
        }
        return value; 
      
    }
}


public class FractionalKnapsack {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        Loot[] loot = new Loot[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            loot[i] = new Loot(values[i], weights[i]);
        }
        
        Helper h = new Helper();
        System.out.println(h.getOptimalValue(capacity, loot));
    }
} 
