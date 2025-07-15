// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int ptr=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[++ptr]=arr[i];
            }
        }
        ++ptr;
        while(ptr<arr.length){
            arr[ptr++]=0;
        }
    }
}