class Solution {
    public static int firstRepeated(int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        int ans=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(set.contains(arr[i])){
                ans=i+1;
            }
            set.add(arr[i]);
        }
        return ans;
    }
}
