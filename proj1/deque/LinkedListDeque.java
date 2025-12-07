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
        sentinel = new DequeNode(null, null, null);
        size = 0;
    }

    public LinkedListDeque(Sort i) {
        sentinel = new DequeNode(sentinel, null, sentinel);
        sentinel.next = new DequeNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(Sort i) {
        if (size == 0) {
            sentinel.next = new DequeNode(sentinel, i, sentinel);
            sentinel.prev = sentinel.next;
            size++;
        }
        else{
            DequeNode p = new DequeNode(sentinel, i, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
            size++;
        }
    }

    public void addLast(Sort i) {
        if (size == 0) {
            sentinel.prev = new DequeNode(sentinel, i, sentinel);
            sentinel.next = sentinel.prev;
            size++;
        }
        else{
            DequeNode p = new DequeNode(sentinel.prev, i, sentinel);
            sentinel.prev.next = p;
            sentinel.prev = p;
            size++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode p = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Sort removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Sort s = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return s;
    }

    public Sort removeLast() {
        if (isEmpty()) {
            return null;
        }
        Sort s = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return s;
    }

    public Sort get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = 0; i < index + 1; i++) {
            sentinel = sentinel.next;
        }
        return sentinel.item;
    }

    public Sort getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        return getRecursive(index - 1);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<?> p = (LinkedListDeque<?>) o;
        if (p.size() != this.size()){
            return false;
        }

        // need to fix
        return true;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addLast(1); // 创建第三个节点后， 第二个节点的 next 指向了第一个
        L.addLast(2);
        L.addLast(3);
        L.removeLast();
        L.removeLast();
    }
}