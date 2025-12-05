package deque;

import java.util.Deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int[] positions = new int[2];
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        positions[0] = 7;
        positions[1] = 1;
        size = 0;
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
        if (size == items.length){
            resize(size * 2);
        }
        items[positions[0]] = i;
        positions[0] = positions[0] - 1;
        size++;
    }

    public void addLast(Item i){
        if (size == items.length){
            resize(size * 2);
        }
        items[positions[1]] = i;
        positions[1] = positions[1] + 1;
        size++;
    }

    public void removeFirst(){
        if (size <= items.length / 4){
            resize(size / 2);
        }
        items[positions[0] + 1] = null;
        positions[0] = positions[0] + 1;
        size--;
    }

    public void removeLast(){
        if (size <= items.length / 4){
            resize(size / 2);
        }
        items[positions[1] - 1] = null;
        positions[1] = positions[1] - 1;
        size--;
    }

    public Item get(int i){
        return items[i];
    } // buggy

    public int size(){
        return size;
    }
}
