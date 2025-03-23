//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    
    
    String buildString(List<List<Integer>> adj,int[] inDegree,Deque<Integer> q,int c){
        StringBuilder sb = new StringBuilder();
        int count=0;
        while(!q.isEmpty()){
            int ele = q.poll();
            count++;
            sb.append((char)(ele+'a'));
            
            for(int each : adj.get(ele)){
                inDegree[each]--;
                if(inDegree[each]==0){
                    q.offer(each);
                }
            }
        }
        
        return (count==c)?sb.toString():"";
    } 
    
    
    
    public String findOrder(String[] words) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] present = new boolean[26];
        int[] inDegree = new int[26];
        int length = words.length;
        for(int i=0;i<length-1;i++){
            String s = words[i];
            String t = words[i+1];
            int len = Math.min(s.length(),t.length());
            boolean flag = false;
            for(int j=0;j<len;j++){
                if(s.charAt(j)!=t.charAt(j)){
                    flag=true;
                    adj.get(s.charAt(j)-'a').add(t.charAt(j)-'a');
                    break;
                }
            }
            if((!flag) && s.length()>t.length()){
                    return "";
            }
        }
        for(String word : words){
            for(char each : word.toCharArray()){
                present[each-'a']=true;
            }
        }
        int c=0;
        for(boolean each : present){
            if(each){
                c++;
            }
        }
        
        // Arrays.fill(inDegree,-1);
        for(List<Integer> list : adj){
            for(int each : list){
                inDegree[each]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int k=0;k<26;k++){
            if(present[k] && inDegree[k]==0){
                q.offer(k);
            }
        }
            
        
        return buildString(adj,inDegree,q,c);
    }
}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends