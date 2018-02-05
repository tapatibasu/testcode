import java.util.*;
 
class Distance {
   int [][] mem;
   
   Distance(String s, String t) {
      mem = new int [s.length()+1][t.length()+1];
  }
  public int EditDistance(String s, String t)
  {
     for (int i = 1; i<mem.length; i++) 
     {
        mem[i][0] = i; 
     }
     for (int j = 0; j < mem[0].length; j++) 
        mem[0][j] = j; 
     for (int i = 1; i < mem.length; i++) {
         for (int j = 1; j < mem[0].length; j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                 mem[i][j] = mem[i-1][j-1]; 
            }
            else {
            	int val1 = mem[i-1][j] + 1; 
            	int val2 = mem[i][j-1] + 1; 
            	int val3 = mem[i-1][j-1] + 1; 
            	mem[i][j] = Integer.min(val1, Integer.min(val2, val3));
            }
        }
     } 
     return mem[mem.length -1][mem[0].length-1];
  }
}

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
     return new Distance(s, t).EditDistance(s, t);
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
