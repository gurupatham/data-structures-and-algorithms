//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;
        if(n<2){
            return -1;
        }
        int max = Integer.MIN_VALUE,ans=Integer.MIN_VALUE;
        for(int each : arr){
            if(each>max){
                ans = max;
                max = each;
                continue;
            }
            if(each <max && each>ans){
                ans=each;
            }
        }
        return ans==Integer.MIN_VALUE ? -1 : ans;
    }
}