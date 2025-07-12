class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int each : arr){
            if(set.contains(each)){
                ans.add(each);
            }
            set.add(each);
        }
        return ans;
    }
}