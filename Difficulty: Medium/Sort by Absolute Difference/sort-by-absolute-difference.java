class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer[] brr = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        Arrays.sort(brr,(a,b)-> {
           return Math.abs(a-x)-Math.abs(b-x);
        });
        for(int i=0;i<arr.length;i++){
            arr[i] = brr[i];
        }
    }
}
