// User function Template for Java

class Solution {
    public int maxXor(int[] nums) {
        // code here
        int maxXor = 0, mask = 0;
    for (int i = 30; i >= 0; i--) {
        mask |= (1 << i);
        Set<Integer> prefixes = new HashSet<>();
        for (int num : nums) {
            prefixes.add(num & mask);
        }
        
        int candidate = maxXor | (1 << i);
        for (int p : prefixes) {
            if (prefixes.contains(p ^ candidate)) {
                maxXor = candidate;
                break;
            }
        }
    }
    return maxXor;

    }
}