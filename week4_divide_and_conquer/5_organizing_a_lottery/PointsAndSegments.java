import java.util.*;

public class PointsAndSegments {
    private static int[] fastCountSegments(int[] starts, int [] ends, int[] points) {
        int[] cnt = new int[points.length];
        Arrays.sort(starts); 
        Arrays.sort(ends); 
        for (int i = 0; i < points.length; i++) {
            int posStart = Arrays.binarySearch(starts, points[i]);
            int posEnd = Arrays.binarySearch(ends, points[i]);
            //int osition = findStartPosition(seg, points[i]);
            if (posStart < 0) {
               posStart += 1;
               posStart *= -1;
            }
            else {
              for (int ii = posStart+1; ii < starts.length; ii++)
              {
                   if (starts[ii] != points[i]) {
                     posStart = ii-1;
                     break; 
                   }
              }
            }
            if (posEnd < 0) {
               posEnd += 1;
               posEnd *= -1;
            }
            else {
              for (int j = posEnd+1; j < ends.length; j++)
              {
                   if (ends[j] != points[i]) {
                     posEnd = j-1;
                     break; 
                   }
              }
            }
            cnt[i] = posStart - posEnd;
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        int [] cnt = fastCountSegments(starts, ends, points);
        //int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

