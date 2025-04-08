//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair{
    String word;
    int level;
    
    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));

        if (!set.contains(targetWord)) {
            return 0; // Target must be in wordList
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String currentWord = p.word;
            int level = p.level;

            for (int i = 0; i < currentWord.length(); i++) {
                char[] wordChars = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordChars[i] != c) {
                        wordChars[i] = c;
                        String newWord = new String(wordChars);

                        if (newWord.equals(targetWord)) {
                            return level + 1;
                        }

                        if (set.contains(newWord)) {
                            q.offer(new Pair(newWord, level + 1));
                            set.remove(newWord);
                        }
                    }
                }
            }
        }

        return 0; 
        
    }
}