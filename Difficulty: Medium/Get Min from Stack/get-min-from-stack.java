//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    
    public Solution() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        stack.push(x);
        int min =x;
        if(minStack.size()>0){
            min = Math.min(min,minStack.peek());
        }
        minStack.push(min);
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(stack.size()==0 || minStack.size()==0){
            return;
        }
        stack.pop();
        minStack.pop();
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        if(stack.size()==0){
            return -1;
        }
        return stack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(minStack.size()==0){
            return -1;
        }
        return minStack.peek();
    }
}