class Solution {
    public String findLargest(int[] arr) {
        // code here
        Integer[] brr = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        long ans = Arrays.stream(arr).sum();
        // System.out.println("Ans is "+ans);
        if(ans==0){
            return "0";
        }
        Arrays.sort(brr,(a,b)->{
          String x = String.valueOf(a);  
          String y = String.valueOf(b);
          String lr=x+y,rl=y+x;
        //   System.out.println("The fin is "+lr + " and is"+rl);
          for(int i=0;i<lr.length();i++){
              if(lr.charAt(i)!=rl.charAt(i)){
                  return rl.charAt(i)-lr.charAt(i);
              }
          }
          return 0;
        });
        StringBuilder sb = new StringBuilder();
        for(int each : brr){
            sb.append(each);
        }
        return sb.toString();
    }
}