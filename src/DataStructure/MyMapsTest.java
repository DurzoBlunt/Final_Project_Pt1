package DataStructure;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapsTest {
    private static MyMaps<String, Integer> accountsMap = new MyMaps();
    @Test
    public void get() throws Exception {
        accountsMap.put("oneaznboy", 10);
        assertEquals((Object)10,accountsMap.get("oneaznboy"));
    }

    @Test
    public void getSize() throws Exception {
        accountsMap.put("oneaznboy", 10);
        assertEquals(1,accountsMap.getSize());
        accountsMap.put("Dart", 20);
        assertEquals(2,accountsMap.getSize());
    }

    @Test
    public void put() throws Exception {
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Dart", 20);
        assertEquals((Object)20,accountsMap.get("Dart"));
        accountsMap.put("Dart", 30);
        assertEquals((Object)30,accountsMap.get("Dart"));
        assertEquals(2, accountsMap.getSize());
    }

    @Test
    public void remove() throws Exception {
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Dart", 20);
        accountsMap.remove("Dart");
        assertEquals(1, accountsMap.getSize());
    }

    @Test
    public void shrinkArray() throws Exception {
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Dart", 20);
        assertEquals(2, accountsMap.getSize());
        accountsMap.remove("oneaznboy");
        assertEquals(1, accountsMap.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(accountsMap.isEmpty());
    }

    @Test
    public void indexOf() throws Exception {
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Kev", 20);
        accountsMap.put("Harambe", 20);
        accountsMap.put("Dart", 20);
        assertEquals(3, accountsMap.indexOf("Dart"));
    }

    @Test
    public void containsKey() throws Exception{
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Kev", 20);
        accountsMap.put("Harambe", 20);
        accountsMap.put("Dart", 20);
        assertTrue(accountsMap.containsKey("Harambe"));
        assertFalse(accountsMap.containsKey("jack"));
    }

    @Test
    public void containsValue() throws Exception{
        accountsMap.put("oneaznboy", 10);
        accountsMap.put("Kev", 20);
        accountsMap.put("Harambe", 20);
        accountsMap.put("Dart", 20);
        assertTrue(accountsMap.containsValue(10));
        assertFalse(accountsMap.containsValue(30));
    }

//    @Test
//    public void toString() throws Exception{
//       try{
//           accountsMap.put("oneaznboy", 10);
//           accountsMap.put("Kev", 20);
//           accountsMap.put("Harambe", 20);
//           accountsMap.put("Dart", 20);
//       } catch (Exception e){
//
//        }
//    }
}