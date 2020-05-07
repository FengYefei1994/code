package Day03.Arraysrewrite;

import org.junit.Test;

import java.util.Arrays;

public class systemarraytest {
    @Test
    public  void test(){
        Integer arr0[] = {0,1,2,3,4};
        Integer arr1[] = {5,6,7,8,9};
        // 讲原数组中若可元素复制到目标数组的指定位置
        // [5, 1, 2, 8, 9]
        System.arraycopy(arr0,1,arr1,1,2);
        System.out.println(Arrays.toString(arr1));
    }
}
