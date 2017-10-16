package DataStructure;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;

public class MyMaps<K, V> implements Serializable {

    private int size;
    private int capacity =  10;
    private MyEntry<K, V>[] values = new MyEntry[capacity];


    public V get(K key){
        for (int i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getKey().equals(key)){
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    public void checkCap(){
        if (size == values.length + 1){
            int newSize = values.length + 10;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public void put(K key, V value){
        boolean insert = true;
        for (int i = 0; i < size; i++){
            if(values[i].getKey().equals(key)){
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert){
            checkCap();
            values[size++] = new MyEntry<K, V>(key, value);
        }
    }

    public void shrinkArray(int startPos){
        for (int i = startPos; i < size; i++){
            values[i] = values[i + 1];
        }
    }

    public void remove(K key){
        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key)){
                values[i] = null;
                size--;
                shrinkArray(i);
            }
        }
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<K>();
        for(int i = 0; i < size; i++){
            set.add(values[i].getKey());
        }
        return set;
    }

    public boolean isEmpty(){
        boolean isEmpty = true;
        if (0 < size){
           isEmpty = false;
        }
       return isEmpty;
    }

    public int indexOf(K key){
        int i;
        for (i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getKey().equals(key)){
                    return i;
                }
            }
        }
        return i;
    }

    public boolean containsKey(K key){
        boolean containsKey = false;
        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key)){
                containsKey = true;
                return containsKey;
            }
        }
        return containsKey;
    }

    public boolean containsValue(V value){
        boolean containsValue = false;
        for (int i = 0; i < size; i++){
            if (values[i].getValue().equals(value)){
                containsValue = true;
                return containsValue;
            }
        }
        return containsValue;
    }

    public String toString(){
        String string = "";
        for (int i = 0; i < size; i++){
                 string += values[i].toString();

        }
        return string;
    }

    public void reset(){
        values = new MyEntry[capacity];
    }
}

