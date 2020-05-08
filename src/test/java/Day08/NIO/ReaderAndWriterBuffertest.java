package Day08.NIO;

import org.junit.Test;

import java.io.*;

//字符流读写中文时，不会乱码
public class ReaderAndWriterBuffertest {
    @Test
    public void testReaderandWriterBuffer(){
        Reader in=null;
        Writer out=null;
        Reader re=null;
        Writer wr=null;
        try {
            in= new FileReader("testfile/file123/笔记.txt");
            out=new FileWriter("testfile/file223/sondir/a.txt",true);

            re=new BufferedReader(in);
            wr=new BufferedWriter(out);

            int c=-1;
            wr.write("\nBuffered:");
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
