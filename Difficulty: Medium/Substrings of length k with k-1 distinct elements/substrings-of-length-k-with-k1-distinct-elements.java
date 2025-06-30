class Solution {
    public int substrCount(String s, int k) {
        // code here
        Set<Character> set = new HashSet<>();
        int[] arr = new int[26];
        int ans=0,end=0,start=0;
        for(int i=0;i<k;i++){
            set.add(s.charAt(i));
            arr[s.charAt(i)-'a']++;
        }
        if(set.size()==k-1){
            ans++;
        }
        end=k;
        while(end<s.length()){
            arr[s.charAt(end)-'a']++;
            set.add(s.charAt(end++));
            arr[s.charAt(start)-'a']--;
            if(arr[s.charAt(start)-'a']==0){
                set.remove(s.charAt(start));
            }
            start++;
            if(set.size()==k-1){
                ans++;
            }
        }
        
        return ans;
    }
}