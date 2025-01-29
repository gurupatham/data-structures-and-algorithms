//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    
    
    
    double power(double b, int e) {
        // code here
        double ans=1d;
        boolean flag=false;
        if(e<0){
            flag=true;
            e=-e;
        }
        
        while(e>0){
            if(e%2==0){
                b*=b;
                e/=2;
            }
            else{
                ans*=b;
                e-=1;
            }
        }
        if(flag){
            return 1/ans;
        }
        
        return ans;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends