//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    void process(List<String> ans,String str,int open,int close,int max){
        if(str.length()==(2*max)){
            ans.add(str);
            return;
        }
        if(open<max){
            process(ans,str+'(',open+1,close,max);
        }
        if(open>close){
            process(ans,str+')',open,close+1,max);
        }
    }
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans = new ArrayList<>();
        process(ans,"",0,0,n);
        return ans;
    }
}