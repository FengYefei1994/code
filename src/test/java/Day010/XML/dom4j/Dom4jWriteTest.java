package Day010.XML.dom4j;

import Day010.XML.Entity.Book;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Dom4jWriteTest {
    @Test
    /*直接获取根节点，然后把子节点、属性、属性值、标签值加入*/
    public void test01() {
        // 使用DocumentHelper中的静态方法createDocument创建文档对象
        Document document = DocumentHelper.createDocument();
        // 向文档对象中元素是addElement(标签名)方法
        Element root = document.addElement("books");
        Element book01 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树伤结樱桃");
        Element book02 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "45").addText("浮城谜事");
        Element book03 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "35").addText("hello树先生");
        FileWriter out = null;
        try {
            out = new FileWriter("src/main/resources/bs01.xml");
            document.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }

    @Test
    /*利用对象方式，把*/
    public void test02() {
        List<Book> list = new ArrayList<Book>() {{
            for (int i = 0; i < 3; i++) {
                add(new Book(i + 1, 30 + i * 5, "book" + (i + 1)));
            }
        }};
        // 使用DocumentHelper中的静态方法createDocument创建文档对象
        Document document = DocumentHelper.createDocument();
        // 向文档对象中元素是addElement(标签名)方法
        Element root = document.addElement("books");
        list.forEach(book -> {
            root.addElement("book").addAttribute("id", String.valueOf(book.getId())).addAttribute("price", String.valueOf(book.getPrice())).addText(book.getValue());
        });
        FileWriter out = null;
        try {
            out = new FileWriter("src/main/resources/bs02.xml");
            document.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }
    @Test
    /*格式化写入*/
    public void test03() {
        // 使用DocumentHelper中的静态方法createDocument创建文档对象
        Document document = DocumentHelper.createDocument();
        // 向文档对象中元素是addElement(标签名)方法
        Element root = document.addElement("books");
        Element book01 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树伤结樱桃");
        Element book02 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "45").addText("浮城谜事");
        Element book03 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "35").addText("hello树先生");
        FileWriter out = null;
        try {
            out = new FileWriter("src/main/resources/bs03.xml");
            // 实例化XMLWriter对象
            XMLWriter xmlWriter = new XMLWriter(out);
            // XMLWriter对象的写方法要求传入一个文档对象
            xmlWriter.write(document);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }
    @Test
    public void test04() {
        // 使用DocumentHelper中的静态方法createDocument创建文档对象
        Document document = DocumentHelper.createDocument();
        // 向文档对象中元素是addElement(标签名)方法
        Element root = document.addElement("books");
        Element book01 = root.addElement("book").addAttribute("id", "1").addAttribute("price", "50").addText("石榴树伤结樱桃");
        Element book02 = root.addElement("book").addAttribute("id", "2").addAttribute("price", "45").addText("浮城谜事");
        Element book03 = root.addElement("book").addAttribute("id", "3").addAttribute("price", "35").addText("hello树先生");
        FileWriter out = null;
        OutputFormat prettyPrint = null;
        try {
            // 使用OutputFormat的静态方法createPrettyPrint获取OutputFormat对象
            prettyPrint = OutputFormat.createPrettyPrint();
            out = new FileWriter("src/main/resources/bs04.xml");
            // 实例化XMLWriter对象
            XMLWriter xmlWriter = new XMLWriter(out,prettyPrint);
            // XMLWriter对象的写方法要求传入一个文档对象
            xmlWriter.write(document);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }
}

