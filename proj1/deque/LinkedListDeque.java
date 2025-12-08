package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class DequeNode {
        public T item;
        public DequeNode prev;
        public DequeNode next;

        public DequeNode(DequeNode p, T i, DequeNode n) {
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

    public LinkedListDeque(T i) {
        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    @Override
    public void addFirst(T i) {
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

    @Override
    public void addLast(T i) {
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

    @Override
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

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T s = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return s;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T s = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return s;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        DequeNode curr = sentinel;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public T getRecursive(int index) {
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
        LinkedListDeque<Integer> L = new LinkedListDeque<>(1);
        L.addFirst(2); // 创建第三个节点后， 第二个节点的 next 指向了第一个
        L.removeFirst();
        L.removeLast();
    }
}