package Day07.IO;

import org.junit.Test;

import java.io.File;

public class copyfiletest {
    @Test
    public void test(){
        copyfile c=new copyfile();
        String old="/home/feng/Documents/JAVAAPI/code/testfile/file123";
        c.setNewPath("/home/feng/Documents/JAVAAPI/code/testfile/file223");
        c.setOldpath(old);
        c.copy2(old);
    }
}
