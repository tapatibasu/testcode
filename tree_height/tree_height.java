import java.util.*;
import java.io.*;

class Tree {
   int n; 
   List<Integer>[] tree; 
   int root ; 
   Tree(int node, int [] t)
   {
      n = node; 
      tree = new ArrayList[n];
      for (int i = 0; i < n; i++) 
        tree[i] = new ArrayList<Integer>();
    
      for (int i = 0; i < n; i++) 
      {
         if (t[i] == -1) root = i;
         if (t[i] != -1) { 
            tree[t[i]].add(i);
         }
      }
    }
    int getHeight()
    {
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        if (tree.length == 0) return 0; 
        int height = 1; 
        q.add(root); 
        while (!q.isEmpty()) 
        {
           int node = q.remove(); 
           for (int i = 0; i < tree[node].size(); i++) 
           {
               s.add(tree[node].get(i));
           }
           if (q.isEmpty() == true) {
                if (s.isEmpty() == false) height++;
           	while (s.isEmpty() == false) 
           	{
              	    q.add(s.pop());
           	}
           }
        }
        return height; 
    }

}

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
                        return new Tree(n, parent).getHeight();
                        /*
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
                        */
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
