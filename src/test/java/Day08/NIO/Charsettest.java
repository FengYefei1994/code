package Day08.NIO;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Charsettest {
    @Test
    public void defaultcharset(){
        System.out.println(Charset.defaultCharset());
        System.out.println(Charset.availableCharsets());
    }
    @Test
    public void setchaarset01(){
        String str1="你好！";
        System.out.println(str1);
        byte[] b1= new byte[0];
        b1 = str1.getBytes(Charset.forName("gbk"));
        System.out.println(new String(b1));
        System.out.println(new String(b1,Charset.forName("gbk")));
    }
    @Test
    public void setchaarset02(){
        String str1="你好！";
        System.out.println(str1);
        byte[] b1;
        try {
            b1=str1.getBytes("gbk");
            System.out.println(new String(b1));
            System.out.println(new String(b1,"gbk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
