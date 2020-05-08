package Day08.NIO;

import org.junit.Test;

import java.io.*;

//字符流读写中文时，不会乱码
public class ReaderAndWritertest {
    @Test
    public void testReaderaWriter(){
        Reader re=null;
        Writer wr=null;
        try {
            re= new FileReader("testfile/file123/笔记.txt");
            wr=new FileWriter("testfile/file223/sondir/a.txt",true);

            int c=-1;
            wr.write("\n普通读写：");
            while((c=re.read())!=-1){
                wr.write((char)c);
            }
            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wr.close();
                re.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
