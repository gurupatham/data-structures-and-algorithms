//{ Driver Code Starts
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine(); // Use lowercase 's'

            Solution ob = new Solution();
            if (ob.isPalindrome(s)) // Check palindrome
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean isPalindrome(String s,int left,int right){
        if(left>=right){
            return true;
        }
        if(s.charAt(left)!=s.charAt(right)){
            return false;
        }
        return isPalindrome(s,++left,--right);
    }
    
    boolean isPalindrome(String s) {
        // code here
        return isPalindrome(s,0,s.length()-1);
    }
};