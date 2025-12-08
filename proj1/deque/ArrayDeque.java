package deque;

public class ArrayDeque<T> implements Deque<T> {
    public T[] items;
    public int[] positions = new int[2];
    public int size;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
    }

    public ArrayDeque(T i) {
        size = 1;
        items = (T[]) new Object[8];
        positions[0] = 7;
        positions[1] = 1;
        items[0] = i;
    }

    public void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        positions[0] = newSize - 1;
        positions[1] = size;
    }

    @Override
    public void addFirst(T i){
        if (size == 0){
            items[0] = i;
            positions[0] = 7;
            positions[1] = 1;
            size++;
        }
        if (size == items.length){
            resize(size * 2);
        }
        items[positions[0]] = i;
        positions[0] = positions[0] - 1;
        size++;
    }

    @Override
    public void addLast(T i){
        if (size == 0){
            items[7] = i;
            positions[0] = 6;
            positions[1] = 0;
            size++;
        }
        if (size == items.length){
            resize(size * 2);
        }
        items[positions[1]] = i;
        positions[1] = positions[1] + 1;
        size++;
    }

    @Override
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        if (size <= items.length / 4 && size > 8){
            resize(items.length / 2);
        }
        int p = positions[0] + 1;
        if (p == items.length){
            p -= items.length;
        }
        T i = items[p];
        items[p] = null;
        positions[0] = p;
        size--;
        return i;
    }

    @Override
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        if (size <= items.length / 4 && size > 8){
            resize(items.length / 2);
        }
        int p = positions[1] - 1;
        if (positions[1] == 0){
            p += items.length;
        }
        T i = items[p];
        items[p] = null;
        positions[1] = p;
        size--;
        return i;
    }

    @Override
    public T get(int index){
        return items[index];
    } // buggy？

    @Override
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque(2);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.removeLast();
        System.out.println(a.get(0));
    }
}
