package Day03.Arraysrewrite;

public class toString {
    public String print(Object[] ob){
        if(ob==null){
            return null;
        }else if(ob.length==0){
            return "[]";
        }else {
            StringBuffer s1=new StringBuffer("[");
            for (int i = 0; i < ob.length; i++) {
                s1.append(ob[i]);
                if(i<ob.length-1){
                    s1.append(",");
                }
            }
            s1.append("]");
            return s1.toString();
        }
    }
}
