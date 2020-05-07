package Day07.IO;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.File;

public class listFilestest {
    @Test
    public void test(){
        File a=new File("file123");
        File[] a1=a.listFiles();
        System.out.println(a1.length);
    }

}
