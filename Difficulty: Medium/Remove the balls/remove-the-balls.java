class Pair{
    int color;
    int radius;
    
    Pair(int color,int radius){
        this.color = color;
        this.radius = radius;
    }
    
}

class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        Deque<Pair> stack = new ArrayDeque<>();
        for(int i=0;i<color.length;i++){
            if(!stack.isEmpty() && stack.peek().color==color[i] && stack.peek().radius==radius[i]){
                stack.pop();
            }
            else{
                stack.push(new Pair(color[i],radius[i]));
            }
        }
        return stack.size();
    }
}