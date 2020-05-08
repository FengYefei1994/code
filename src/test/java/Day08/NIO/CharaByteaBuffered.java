package Day08.NIO;

import org.junit.Test;

import java.io.*;

//字符流读写中文时，不会乱码
public class CharaByteaBuffered {
    @Test
    public void testCharaByteaBuffered(){
        //字节处理流
        InputStream is=null;
        OutputStream os=null;

        //中间处理流（可以省略In/OutputStream）
        InputStreamReader in=null;
        OutputStreamWriter out=null;

        //缓冲流
        BufferedReader re=null;
        BufferedWriter wr=null;

        try {
            is= new FileInputStream("testfile/file123/笔记.txt");
            os= new FileOutputStream("testfile/file223/sondir/a.txt",true);

            in=new InputStreamReader(is);
            out=new OutputStreamWriter(os);

            //设置编码方式为gbk
            /*in=new InputStreamReader(is,Charset.forName("gbk"));
            out=new OutputStreamWriter(os,Charset.forName("gbk"));*/

            re=new BufferedReader(in);
            wr=new BufferedWriter(out);

            String c=null;
            wr.write("\n带缓冲的字节转为字符:");
            while((c=re.readLine())!=null){
                wr.write(c);
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
