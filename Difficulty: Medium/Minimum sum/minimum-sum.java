class Solution {
    
    StringBuilder add(StringBuilder a,StringBuilder b){
        int carry=0,m=a.length(),n=b.length(),i=0,j=0;
        StringBuilder ans = new StringBuilder();
        while(i<m && j<n){
            int sum = (a.charAt(i)-'0' + b.charAt(j)-'0' + carry)%10;
            ans.append(sum);
            carry = (a.charAt(i)-'0' + b.charAt(j)-'0' + carry)/10;
            i++;
            j++;
        }
        while(i<m){
            int sum = (a.charAt(i)-'0' + carry)%10;
            ans.append(sum);
            carry = (a.charAt(i)-'0' + carry)/10;
            i++;
        }
        while(j<n){
            int sum = (a.charAt(j)-'0' + carry)%10;
            ans.append(sum);
            carry = (a.charAt(j)-'0' + carry)/10;
            j++;
        }
        if(carry>0){
            ans.append(carry);
        }
        return ans;
    }
    
    String minSum(int[] arr) {
        // code here
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                a.append(arr[i]);
                continue;
            }
            b.append(arr[i]);
        }
        StringBuilder sortedValue = add(a.reverse(),b.reverse());
        int i=sortedValue.length()-1,zeroCount=0;
        while(i>=0){
            if(sortedValue.charAt(i)=='0'){
                zeroCount++;
            }
            else{
                break;
            }
            i--;
        }
        sortedValue.setLength(sortedValue.length()-zeroCount);
        return sortedValue.reverse().toString();
        
    }
}
