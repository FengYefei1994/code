package Day03.Arraysrewrite;

import java.io.Serializable;

/**
 * @author 李昊哲
 */
public class ArrayList implements List, Serializable {
    // 底层存储
    private transient Object[] elementData;
    // 元素的数量
    private int size;

    public ArrayList() {
        this(10);
    }
    public ArrayList(int initialCapacity) throws IllegalArgumentException{
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object object) {
        // 计数器
        int count = size;
        // 确保存储空间能够存储新的数据
        ensureCapacity(size + 1);
        // 向容器中存储值
        elementData[size++] = object;
        if(size > count){
            return true;
        }
        return false;
    }
    // 确保存储空间能够存储新的数据
    private void ensureCapacity(int minCapacity) {
        if (minCapacity == elementData.length){
            // 获取原数组长度
            int oldCapacity = elementData.length;
            // 新数组长度为原数组长度的1.5倍
            // int newCapacity = oldCapacity + (oldCapacity / 1 );
            int newCapacity = oldCapacity + (oldCapacity >> 1 );
            // 使用传入的值和原数组1.5的最大值作为新数组的长度
            newCapacity = Math.max(minCapacity,newCapacity);
            // 空间不够数组扩容
            elementData = ArrayUtil.copy(elementData,newCapacity);
        }
    }

    @Override
    public Object get(int index) {
        checkRang(index);
        return elementData[index];
    }

    private void checkRang(int index) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("数学异常，错误的index值，错误的值为>>>: " + index);
        }
    }
    @Override
    public String toString(){
        if (this != null && size > 0) {
            String msg = "[";
            for (int i = 0; i < size; i++) {
                msg += get(i);
                if (i < size - 1) {
                    msg += ", ";
                }
            }
            msg += "]";
            return msg;
        } else if(this != null && size == 0){
            return "[]";
        }
        return null;
    }
    @Override
    public void remove(int index) {
        checkRang(index);
        // size - index -1 = 拷贝元素的长度
        systemarray.arrayCopy(elementData,index + 1,elementData,index,size - index -1 );
        // 将最后一个index元素的值制空并且元素数量减一
        elementData[--size] = null;
    }
}