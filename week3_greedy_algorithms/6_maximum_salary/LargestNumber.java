import java.util.*;

class myNumber {
   class Sortbyname implements Comparator<String>
   {
    public int compare(String a, String b)
    {
        String xy = a + b;
        String yx = b + a; 
        return yx.compareTo(xy);
    }
  }
   public String largestNumber(String[] a) {
        
        Arrays.sort(a, new Sortbyname());
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }
}

public class LargestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        myNumber m = new myNumber();
        
        System.out.println(m.largestNumber(a));
    }
}

