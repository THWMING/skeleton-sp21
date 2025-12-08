package deque;

import net.sf.saxon.om.Item;

import java.util.Comparator;

public class MaxArrayDeque<T> implements Deque<T> {
    private ArrayDeque<T> Arraydeque;
    private Comparator<T> DefaultC;

    public MaxArrayDeque(Comparator<T> comparator){
         this.Arraydeque = new ArrayDeque<>();
         this.DefaultC = comparator;
    }

    public T max(){
        if (Arraydeque.isEmpty()){
            return null;
        }
        return max(DefaultC);
    }

    public T max(Comparator<T> comparator){
        if (Arraydeque.isEmpty()){
            return null;
        }
        T max = Arraydeque.get(0);
        for (int i = 1; i < Arraydeque.size(); i++){
            if (comparator.compare(Arraydeque.get(i), max) > 0){
                max = Arraydeque.get(i);
            }
        }
        return max;
    }

    public void resize(int size){
        Arraydeque.resize(size);
    }

    @Override
    public void addFirst(T item){
        Arraydeque.addFirst(item);
    }

    @Override
    public void addLast(T item){
        Arraydeque.addLast(item);
    }

    @Override
    public T removeFirst(){
        return Arraydeque.removeFirst();
    }

    @Override
    public T removeLast(){
        return Arraydeque.removeLast();
    }


    @Override
    public int size(){
        return Arraydeque.size();
    }

    @Override
    public T get(int index){
        return Arraydeque.get(index);
    }
}
