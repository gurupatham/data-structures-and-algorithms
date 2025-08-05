class Solution {
    public int romanToDecimal(String s) {
        // code here
        
        Map<Character,Integer> map = new HashMap<>();
        int ans=0;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        ans=map.get(s.charAt(s.length()-1));
        int prev = ans;
        for(int i=s.length()-2;i>=0;i--){
            int curr = map.get(s.charAt(i));
            if(curr>=prev){
                ans+=curr;
            }
            else{
                ans-=curr;
            }
            prev=curr;
        }
        return ans;
        
    }
}