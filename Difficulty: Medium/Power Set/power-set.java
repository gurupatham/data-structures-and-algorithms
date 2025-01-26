//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    void process(String s,int i,StringBuilder sb,List<String> ans){
        if(i==s.length()){
            ans.add(sb.toString());
            return;
        }
        sb.append(s.charAt(i));
        process(s,i+1,sb,ans);
        sb.setLength(sb.length()-1);
        process(s,i+1,sb,ans);
    }
    
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        process(s,0,sb,ans);
        Collections.sort(ans);
        return ans;
    }
}