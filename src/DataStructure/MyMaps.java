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

    //gets the Value of the given Key
    public V get(K key) throws NullPointerException{
        for (int i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getKey().equals(key)){
                    return values[i].getValue();
                }
            }
            else{
                throw (new NullPointerException("The value is null!"));
            }
        }
        return null;
    }

    //gets the quantity of elements in the Map
    public int getSize(){
        return size;
    }

    //checks and changes capacity of the map
    public void checkCap(){
        if (size == values.length + 1){
            int newSize = values.length + 10;
            values = Arrays.copyOf(values, newSize);
        }
    }

    //adds the Entry to the map, if it exists, it edits the value;
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

    //Shrinks the array after deleting an element
    public void shrinkArray(int startPos) throws RemoveEmptyArrayException{
        if(getSize() == 0){
            throw (new RemoveEmptyArrayException("Array is null or empty"));
        }
        for (int i = startPos; i < size; i++){
            values[i] = values[i + 1];
        }
    }

    //Calls shrinkArray, removes element from the map.
    public void remove(K key) throws RemoveEmptyArrayException{

        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key)){
                values[i] = null;
                size--;
                shrinkArray(i);
            }
        }
    }

    //Provides a set of Keys
    public Set<K> keySet(){
        Set<K> set = new HashSet<K>();
        for(int i = 0; i < size; i++){
            set.add(values[i].getKey());
        }
        return set;
    }

    //Checks if map is empty
    public boolean isEmpty(){
        boolean isEmpty = true;
        if (0 < size){
           isEmpty = false;
        }
       return isEmpty;
    }

    //returns the index of an element
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

    //Boolean checks the map for a Key
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

    //boolean checks the map for a Value
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

    @Override
    public String toString(){
        String string = "";
        for (int i = 0; i < size; i++){
                 string += values[i].toString();

        }
        return string;
    }

    //Resets the map
    public void reset(){
        values = new MyEntry[capacity];
    }
}

