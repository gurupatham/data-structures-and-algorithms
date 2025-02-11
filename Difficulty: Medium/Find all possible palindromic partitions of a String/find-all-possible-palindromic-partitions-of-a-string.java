//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void process(String s,int idx,ArrayList<String> ds,ArrayList<ArrayList<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                ds.add(s.substring(idx,i+1));
                process(s,i+1,ds,ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    
    static boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        process(S,0,new ArrayList<>(),ans);
        return ans;
    }
}