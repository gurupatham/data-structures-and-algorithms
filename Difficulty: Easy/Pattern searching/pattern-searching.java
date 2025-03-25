//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String str;
            str = br.readLine();

            String pat;
            pat = br.readLine();

            Solution obj = new Solution();
            boolean res = obj.searchPattern(str, pat);

            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean searchPattern(String txt, String pat) {
        // code here
        for(int i=0;i<=txt.length()-pat.length();i++){
            boolean flag=true;
            for(int j=0;j<pat.length();j++){
                if(txt.charAt(i+j)!=pat.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}
