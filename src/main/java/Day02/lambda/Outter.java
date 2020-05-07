package Day02.lambda;

public class Outter {

/*    static class inner{
        public static void print(){
            System.out.println("hello");
        }
    }
*/

/*    class inner{
        public void print(){
            System.out.println("hello");
        }
    }
*/

    /*
    class inner{
        public void print(){
            System.out.println("hello");
        }
    }
    public void askinner(){
        new inner().print();
    }
     */
/*
    public static void excinnerp() {
        class inner{
            public void print(){
                System.out.println("hello");
            }
        }
        new inner().print();
    }
*/
/*
    public void excinnerp() {
        class inner{
            public void print(){
                System.out.println("hello");
            }
        }
        new inner().print();
    }
*/

    public void excinnerp() {
        class inner{}
        new inner(){
            //此时的print方法是子类特有的
            public void print(){
                System.out.println("hello");
            }
        }.print();
    }


}
