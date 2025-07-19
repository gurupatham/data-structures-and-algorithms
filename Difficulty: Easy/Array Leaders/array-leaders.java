class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int leader = arr[arr.length-1];
        ans.add(leader);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=leader){
                leader = arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
