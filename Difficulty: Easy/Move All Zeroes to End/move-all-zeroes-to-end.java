//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
    
    void pushZerosToEnd(int[] arr) {
        // code here
        for(int i=0,ans=-1;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,++ans,i);
            }
        }
    }
}