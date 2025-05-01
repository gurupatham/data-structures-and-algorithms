//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to perform case-specific sorting of strings.
    static String sort(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            while(val>0){
                sb.append((char)i);
                val--;
            }
        }
        return sb.toString();
    }
    
    public static String caseSort(String str) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        int[] lower = new int[256];
        int[] upper = new int[256];
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                upper[str.charAt(i)]++;
            }
            else{
                lower[str.charAt(i)]++;
            }
        }
        String lowSort= sort(lower);
        String uppSort = sort(upper);
        for(int i=0,j=0,k=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                sb.append(uppSort.charAt(j++));
            }
            else{
                sb.append(lowSort.charAt(k++));
            }
        }
        
        return sb.toString();
    }
}


//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    
out.println("~");
}
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends