package Day08.NIO;

import Day08.NIO.Serialization.Person;
import org.junit.Test;

import java.io.*;

public class Serializationtest {
    @Test
    public void testwriter() {
        OutputStream os = null;
        ObjectOutputStream oout = null;

        try {
            os = new FileOutputStream("testfile/file223/Person.txt", true);
            oout = new ObjectOutputStream(os);
            oout.writeObject(new Person("张三", 25, "user", "123456"));
            oout.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oout.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testreader() {
        InputStream is = null;
        ObjectInputStream oin = null;

        try {
            is = new FileInputStream("testfile/file223/Person.txt");
            oin = new ObjectInputStream(is);
            Person p1 = (Person) oin.readObject();
            System.out.println(p1.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
