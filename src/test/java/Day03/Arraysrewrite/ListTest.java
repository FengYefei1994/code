package Day03.Arraysrewrite;

import Day03.Arraysrewrite.ArrayList;
import Day03.Arraysrewrite.List;
import org.junit.Test;

public class ListTest {
    @Test
    public void size() {
        List list = new ArrayList();
        System.out.println("size >>> " + list.size());
    }

    @Test
    public void add() {
        List list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        System.out.println("size >>> " + list.size());
    }

    @Test
    public void get() {
        List list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        System.out.println(list.get(11));
    }

    @Test
    public void getAll() {
        List list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void toStringTest() {
        List list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
    }

    @Test
    public void remove() {
        List list = new ArrayList();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        System.out.println("size >>> " + list.size() + "\t element >>> " + list.toString());
        list.remove(7);
        System.out.println("size >>> " + list.size() + "\t element >>> " + list.toString());
    }
}