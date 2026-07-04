public class Node{
     int key;
     int val;
     Node next;
     Node prev;

    public Node(int key, int val){
        System.out.println(key + "-" + val);
        this.key= key;
        this.val = val;
    }
}

class LRUCache {

    private Map<Integer, Node> map;
    private Node rightDummy;
    private Node leftDummy;
    private int cap = 0;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.rightDummy = new Node(0,0); //MRU
        this.leftDummy = new Node(0,0); //LRU
        this.rightDummy.prev = this.leftDummy;
        this.leftDummy.next = this.rightDummy;
        this.cap = capacity;
    }

    public void remove(Node n){
        System.out.println("remove :: " + n.key);
        Node prev= n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;   
        System.out.println("remove :: right " + this.rightDummy.prev.key + " left " + this.leftDummy.next.key);
    }

    public void insert(Node n){
        System.out.println("insert :: " + n.key);
        Node right = this.rightDummy.prev;
        Node rightNext = this.rightDummy;
        n.next =rightNext;
        n.prev = right;
        rightNext.prev=n;
        right.next = n;
        System.out.println("insert :: right " + this.rightDummy.prev.key + " left " + this.leftDummy.next.key);
    }
    
    public int get(int key) {
        if(this.map.get(key) != null){
            Node n = this.map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.get(key) != null){
            remove(map.get(key));
        }
        Node n = new Node(key, value);
        this.map.put(key, n);
        insert(n);

        if(this.map.size() > cap){
           Node leftMost = this.leftDummy.next;
           this.map.remove(leftMost.key);
           remove(leftMost);
        }
    }
}
