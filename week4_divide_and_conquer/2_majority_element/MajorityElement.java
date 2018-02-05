import java.util.*;
import java.io.*;

public class MajorityElement {
   private static Random random = new Random();

    private static int[] partition3(int[] a) {
        int l = 0; 
        int r = a.length -1;
        int x = a[l];
        int j = l;
        int k = r ;
        int i = l + 1;
        while (i<= k) {
            if (a[i] < x) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j++;
                i++;
            }
            else if (a[i] > x) {
               int t = a[i];
               a[i] = a[k];
               a[k] = t;
               k--;
            }
            else if (a[i] == x) i++;
        }
        int [] m = {j, k};
        return m;
    }

    private static int getMajorityElement(int[] a, int len) {
        if (a.length <= len/2) return -1;
        int l = 0; 
        int r = a.length -1;
        
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        int [] m = partition3(a);
        int val = m[1] - m[0] + 1;
        if (val > len/2) return a[m[0]];
        int leftSize = m[0]; 
        int rightSize = a.length - m[1];
        if (leftSize > len/2) {
          return getMajorityElement(Arrays.copyOfRange(a, 0, m[0]), len);
        }
        else if (rightSize > len/2) {
          return getMajorityElement(Arrays.copyOfRange(a, m[1]+1, a.length), len);
        }
        return -1;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a,a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

