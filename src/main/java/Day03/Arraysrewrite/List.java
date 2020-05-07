package Day03.Arraysrewrite;

public interface List {

    /**
     * 获取集合中元素的数量
     *
     * @return 集合中元素的数量
     */
    public abstract int size();

    /**
     * 向集合中添加元素
     *
     * @param object 元素
     * @return
     */
    public abstract boolean add(Object object);

    /**
     * 根据输入的index获取该位置上元素的值
     *
     * @param index 输入集合中元素值的index位置
     * @return 返回集合中index位置上元素的的值
     */
    public abstract Object get(int index);

    /**
     * 将集合中元素的值转为字符串
     *
     * @return 集合中元素的值
     */
    @Override
    public abstract String toString();

    /**
     * 移除某index位置上的元素
     *
     * @param index 输入集合中欲元素值的index位置
     */
    public abstract void remove(int index);

}
