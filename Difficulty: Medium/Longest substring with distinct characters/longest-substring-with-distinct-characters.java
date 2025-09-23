class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int ans=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int l=0,r=0;r<s.length();r++){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r))>=l){
                l=map.get(s.charAt(r))+1;
            }
            map.merge(s.charAt(r),r,Integer::max);
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}