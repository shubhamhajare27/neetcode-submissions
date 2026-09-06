
class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key,int value){
        this.key=key;
        this.val=value;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    public void remove(Node newn){
        Node prev = newn.prev;
        Node next = newn.next;
        prev.next=next;
        next.prev=prev;
    }

    public void insertLast(Node newn){
        Node prev= this.tail.prev;
        prev.next=newn;
        newn.prev=prev;
        newn.next=this.tail;
        this.tail.prev=newn;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node newn = map.get(key);
        remove(newn);
        insertLast(newn);
        return newn.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newn = new Node(key,value);
        map.put(key,newn);
        insertLast(newn);
        if(map.size() > capacity){
            Node lru = this.head.next;
            map.remove(lru.key);
            remove(lru);
        }
    }
}
