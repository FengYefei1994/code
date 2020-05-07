package Day03.Arraysrewrite;

public abstract class ArrayUtil {
    /**
     * 数组的拷贝
     *
     * @param src       源数组
     * @param newLength 新数组长度
     * @return 新数组
     */
    public static Object[] copy(Object[] src, int newLength) {
        // 实例化新数组长度为newLength
        Object[] dest = new Object[newLength];
        if(newLength >= src.length){
            // 新数组长度不小于源数组长度 则按照源数组长度遍历源数组
            for (int i = 0; i < src.length; i++) {
                // 将源数组中元素的值存储到新数组中
                dest[i] = src[i];
            }
        }else{
            // 新数组长度小于源数组长度 则按照新数组长度遍历源数组
            for (int i = 0; i < newLength; i++) {
                // 将源数组中元素的值存储到新数组中
                dest[i] = src[i];
            }
        }
        return dest;
    }
    /**
     * 数组的拷贝
     *
     * @param src       源数组
     * @param newLength 新数组长度
     * @return 新数组
     */
    public static Object[] copyOf(Object[] src, int newLength) {
        // 实例化新数组长度为newLength
        Object[] dest = new Object[newLength];
        if(newLength >= src.length){
            // 新数组长度不小于源数组长度 则按照源数组长度遍历源数组
            systemarray.arrayCopy(src,0,dest,0,src.length);
        }else{
            // 新数组长度小于源数组长度 则按照新数组长度遍历源数组
            systemarray.arrayCopy(src,0,dest,0,newLength);
        }
        return dest;
    }

    /**
     * 遍历数组元素的值以字符串的形式
     * @param arrays    数组
     * @return  数组元素的值以字符串的形式
     */
    public static String toString(Object[] arrays) {
        if (arrays != null && arrays.length > 0) {
            String msg = "[";
            for (int i = 0; i < arrays.length; i++) {
                msg += arrays[i];
                if (i < arrays.length - 1) {
                    msg += ", ";
                }
            }
            msg += "]";
            return msg;
        } else if(arrays != null && arrays.length == 0){
            return "[]";
        }
        return null;
    }
}