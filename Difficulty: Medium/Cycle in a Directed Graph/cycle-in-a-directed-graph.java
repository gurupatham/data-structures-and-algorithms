//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        int[] inDegree = new int[v];
        Deque<Integer> q = new ArrayDeque<>();
        for(List<Integer> list : adj){
            for(int each : list){
                inDegree[each]++;
            }
        }
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        // System.out.println("arr is "+Arrays.toString(inDegree));
        int counter=0;
        while(!q.isEmpty()){
            int node = q.poll();
            counter++;
            for(int each : adj.get(node)){
                inDegree[each]--;
                if(inDegree[each]==0){
                    q.offer(each);
                }
            }
        }
        // System.out.println("The ans is "+counter);
        return counter!=v;
        
    }
}