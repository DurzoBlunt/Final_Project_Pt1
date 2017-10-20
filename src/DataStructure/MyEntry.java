package DataStructure;

import java.io.Serializable;
import java.security.Key;

public class MyEntry<K, V> implements Serializable {
    private final K key;
    private V value;

    public MyEntry(K key, V value){
        this.key = key;
        this.value = value;
    }
    //Returns key
    public K getKey(){
        return key;
    }

    //returns value
    public V getValue(){
        return value;
    }

    //set the value
    public void setValue(V value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Key = " + this.key + ", Value = " + this.value + " ";
    }



}
