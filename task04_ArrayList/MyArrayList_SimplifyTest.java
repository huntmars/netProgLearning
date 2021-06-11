import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayList_SimplifyTest {
    private MyArrayList_Simplify<Integer> alist;

    private void printList(){
        for (int i = 0; i < alist.size(); i++) {
            System.out.print(alist.get(i) + " ");
        }
        System.out.println();
    }
    @Before
    public void init() {
        alist = new MyArrayList_Simplify<Integer>();
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, alist.size());
        for (int i = 0; i < 10; i++) {
            alist.add(i+1);
        }
        assertEquals(10, alist.size());
    }

    @Test
    public void get() throws Exception {
        try{
            assertNull(alist.get(1));
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            alist.add(i+1);
        }
        assertEquals(Integer.valueOf(1), alist.get(0));
    }

    @Test
    public void insert() throws Exception {
        for (int i = 0; i < 10; i++) {
            alist.add(i+1);
        }
        alist.insert(2, 22);
        assertEquals(Integer.valueOf(22), alist.get(2));
    }

    @Test
    public void add() throws Exception {
        try{
            assertNull(alist.get(1));
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        alist.add(1);
    }

    @Test
    public void isContains() throws Exception {
        assertFalse(alist.isContains(1));
        alist.add(2);
        assertTrue(alist.isContains(2));
    }

    @Test
    public void removeAt() throws Exception {
        for (int i = 0; i < 10; i++) {
            alist.add(i+1);
        }
        assertEquals(Integer.valueOf(1), alist.get(0));
        assertEquals(Integer.valueOf(1), alist.removeAt(0));
        assertEquals(Integer.valueOf(2), alist.get(0));
    }

    @Test
    public void remove() throws Exception {
        for (int i = 0; i < 10; i++) {
            alist.add(i+1);
        }
        alist.add(5);
        alist.add(5);
        alist.add(5);
        assertFalse(alist.remove(100)); // 100 does not exist
        assertTrue(alist.remove(5));
        assertFalse(alist.isContains(5)); // successfully remove elements with value 5
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(alist.isEmpty());
        alist.add(1);
        assertFalse(alist.isEmpty());
    }
}