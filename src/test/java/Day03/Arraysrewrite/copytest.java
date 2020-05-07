package Day03.Arraysrewrite;

import Day03.Arraysrewrite.copy;
import org.junit.Test;

import java.util.Arrays;

public class copytest {
    @Test
    public void test01(){
        Integer[] a1={2,5,1,6,4};
        Object[] a2=new copy().copyarr(a1,9);
        System.out.println(Arrays.toString(a2));
    }
}
