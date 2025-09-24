class Solution {
    
    String getBin(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n/=2;
        }
        return sb.reverse().toString();
    }
    
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(getBin(i));
        }
        return ans;
    }
}
