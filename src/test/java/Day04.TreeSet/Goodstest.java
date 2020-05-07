package Day04.TreeSet;

import org.junit.Test;
import java.util.*;

public class Goodstest {
    @Test
    public void test() {
        //数据初始化
        Set<Goods> s1 = new TreeSet<Goods>();
        s1.add(new Goods("华为", 35, 65));
        s1.add(new Goods("中兴", 65, 90));
        s1.add(new Goods("OPPO", 80, 78));
        s1.add(new Goods("小米", 89, 90));
        s1.add(new Goods("苹果", 23, 67));

        Iterator<Goods> it = s1.iterator();
        while (it.hasNext()) {
            Goods goods=it.next();
            System.out.println(goods.toString());
        }
    }
}
