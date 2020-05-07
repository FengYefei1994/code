package Day03.Arraysrewrite;

public class systemarray {
    /**
     * 将源数组中指定index位置上元素的值拷贝到目标数组指定index位置
     * @param src		源数组
     * @param srcPos	源数组指定index
     * @param dest		目标数组
     * @param destPos	目标数组指定index
     * @param length	拷贝长度
     */
    public static void arrayCopy(Object[] src, int srcPos,Object[] dest, int destPos,int length) {
        // 临时数组存储被拷贝的值
        Object[] temp = new Object[length];
        for (int i = 0; i < length; i++) {
            // 备份源数组中欲被拷贝的元素的值
            temp[i] = src[i + srcPos];
        }
        for (int i = 0; i < length; i++) {
            // 将备份的数据存储到目标数组的指定index位置上
            dest[i + destPos] = temp[i];
        }
    }
}
