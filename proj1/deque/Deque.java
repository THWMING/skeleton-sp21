package deque;

public interface Deque<T> {
    default public boolean isEmpty(){
        return this.size() == 0;
    }
    public int size();
    public void addFirst(T i);
    public void addLast(T i);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
