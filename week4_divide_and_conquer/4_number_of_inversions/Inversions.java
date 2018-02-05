import java.util.*;

class Counting {
   long numInversion;
   public Counting() 
   {
      numInversion = 0; 
   }

    public int [] mergeSort(int[] a) {
       int l = 0; 
       int r = a.length - 1;
       if (l == r) return a;
       if (l+1 == r) {
          if (a[l] > a[r]) 
          {
              numInversion++;
              int t = a[l];
              a[l] = a[r];
              a[r] = t; 
          }
          return a;
       }
       int mid = (int)Math.floor((r-l)/2);
       int [] x = mergeSort(Arrays.copyOfRange(a, l, mid));
       int [] y = mergeSort(Arrays.copyOfRange(a, mid, r+1));
       return merge(x, y);
    }
    int [] merge(int[] a, int b[])
    {
       int i = 0; 
       int j = 0; 
       int l1 = a.length; 
       int l2 = b.length; 
       int [] c = new int[l1 + l2];
       int k = 0; 
       while (i < l1 && j < l2) 
       {
          if (a[i] <= b[j]) {
             c[k] = a[i];
             i++;
             k++;
          }
          else {
             c[k] = b[j];
             j++;
             k++;
             numInversion += (long)l1 - i ;
          }
       }
       if (i < l1) 
       {
          while (i < l1) 
          {
             c[k] = a[i];
             k++; i++;
          }
       }
       if (j < l2) 
       {
          while (j < l2) 
          {
             c[k] = b[j];
             k++; j++;
          }
       }
       return c; 
    }
}

public class Inversions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Counting c = new Counting();
        int[] b = c.mergeSort(a);
        System.out.println(c.numInversion);
        /*
        for (int i = 0; i < n; i++) {
           System.out.println(b[i]);
        }
        */
    }
}

