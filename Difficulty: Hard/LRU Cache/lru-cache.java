//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
    
}


class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    static int capacity;
    static Node head,tail;
    
    private static Map<Integer,Node> map;
    
    LRUCache(int cap) {
        // code here
        map = new HashMap<>();
        capacity = cap;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        process(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            process(node);
            return;
        }
        Node node = new Node(key,value);
        if(getSize()==capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        map.put(key,node);
        insertAtHead(node);
    }
    
    static void process(Node node){
        remove(node);
        insertAtHead(node);
    }
    
    
    private static void insertAtHead(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev=head;
        node.next = temp;
        temp.prev = node;
    }
    
    private static void remove(Node node){
        Node tempPrev = node.prev;
        Node tempNext = node.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }
    
    static int getSize(){
        return map.keySet().size();
    }
    
    
}
