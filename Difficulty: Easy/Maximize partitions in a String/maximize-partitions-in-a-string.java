//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        int ans=0;
        for(int start=0;start<s.length();){
            int end = s.lastIndexOf(s.charAt(start));
            for(int i=start+1;i<=end;i++){
                if(s.lastIndexOf(s.charAt(i)) > end){
                    end = s.lastIndexOf(s.charAt(i));
                }
            }
            start=end+1;
            ans++;
        }
        
        return ans;
        
    }
}