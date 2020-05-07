package Day07.IO;

import java.io.*;

import org.junit.Test;

public class Filetest {

    @Test
    public void te(){
        InputStream in=null;
        OutputStream out=null;
        InputStream in2=null;
        OutputStream out2=null;

        try {
            in =new FileInputStream("file");
            out =new FileOutputStream("file2");

            in2=new BufferedInputStream(in);
            out2=new BufferedOutputStream(out);

            int read=-1;
            while((read=in2.read())!=-1) {
                out2.write(read);
            }
            out2.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                out2.close();
                out.close();
                in2.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}