package deque;

public class LinkedListDeque<Sort> {
    private class DequeNode {
        public Sort item;
        public DequeNode prev;
        public DequeNode next;

        public DequeNode(DequeNode p, Sort i, DequeNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    public DequeNode sentinel;
    public int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new DequeNode(null, null, null);
    }

    public LinkedListDeque(Sort i) {
        size = 1;
        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, i, sentinel);
        sentinel = new DequeNode(sentinel.prev,null, sentinel.next);
    }

    public void addFirst(Sort i) {
        size++;
        sentinel.next = new DequeNode(sentinel, i, sentinel.next);
    }

    public void addLast(Sort i) {
        size++;
        sentinel.prev = new DequeNode(sentinel.next, i, sentinel);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        DequeNode p = sentinel.next;
        for(int i = 0; i < size - 1; i++){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Sort removeFirst(){
        if(isEmpty()){
            return null;
        }
        Sort s = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return s;
    }

    public Sort removeLast(){
        if(isEmpty()){
            return null;
        }
        Sort s = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return s;
    }

    public Sort get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        for (int i = 0; i < index + 1; i++){
            sentinel = sentinel.next;
        }
        return sentinel.item;
    }

    public Sort getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        if (index == 0){
            return sentinel.next.item;
        }
        return getRecursive(index - 1);
    }



    public static void main(String[] args) {
    }
}
