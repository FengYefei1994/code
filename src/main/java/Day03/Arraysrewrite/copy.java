package Day03.Arraysrewrite;

public class copy {
    //实现Arrays.copyOf方法
    public Object[] copyarr(Object ob[],int len){
        Object[] newarr=new Object[len];
        if(ob!=null){
            if(len>=ob.length){
                for (int i=0;i<ob.length;++i){
                    newarr[i]=ob[i];
                }
            }else{
                for (int i=0;i<len;++i){
                    newarr[i]=ob[i];
                }
            }
            return newarr;
        }
        return null;
    }
}
