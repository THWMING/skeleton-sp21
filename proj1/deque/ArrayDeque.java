package deque;

import java.util.Deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int[] positions = new int[2];
    private int size;

    public ArrayDeque() {
        size = 0;
        items = (Item[]) new Object[8];
    }

    public ArrayDeque(Item i) {
        size = 1;
        items = (Item[]) new Object[8];
        positions[0] = 7;
        positions[1] = 1;
        items[0] = i;
    }

    public void resize(int newSize){
        Item[] newItems = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        positions[0] = newSize - 1;
        positions[1] = size;
    }

    public void addFirst(Item i){
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

    public void addLast(Item i){
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

    public Item removeFirst(){
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
        Item i = items[p];
        items[p] = null;
        positions[0] = p;
        size--;
        return i;
    }

    public Item removeLast(){
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
        Item i = items[p];
        items[p] = null;
        positions[1] = p;
        size--;
        return i;
    }

    public Item get(int i){
        return items[i];
    } // buggy？

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
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
