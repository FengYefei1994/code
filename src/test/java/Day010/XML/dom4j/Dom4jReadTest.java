package Day010.XML.dom4j;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Dom4jReadTest {
    InputStream in = null;
    URL url = null;
    @Before
    public void init(){
        // 获取该文件的字节输入流
        in = Dom4jReadTest.class.getClassLoader().getResourceAsStream("book_shop.xml");
        // 获取该文件URL
        url = Dom4jReadTest.class.getClassLoader().getResource("book_shop.xml");
    }
    @Test
    /*获取根元素后，直接获取子元素，再根据元素名称获取值*/
    public void parse01() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document read = reader.read(in);
            // 获取根元素(树根)
            Element document = read.getRootElement();
            // 获取根元素下的直接子元素
            Iterator<Element> ei = document.elementIterator();
            Element element = null;
            while (ei.hasNext()) {
                element = ei.next();
                // getName获取元素名称 getTextTrim获取元素内容字符串并将该内容字符串首尾祛空格
                System.out.print(element.getName() + "\t");
                //获取属性的值，括号中写元素属性名称
                System.out.print("id = " + element.attributeValue("id") + "\t");
                System.out.print("price = " + element.attributeValue("price") + "\t");
                System.out.print(element.getTextTrim() + "\n");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取根元素后，直接获取子元素，先获取元素名称，再获取元素值*/
    public void parse02() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // 获取根元素(树根)
            Element root = document.getRootElement();
            // 获取根元素下的直接子元素
            Iterator<Element> ei = root.elementIterator();
            Element element = null;
            Iterator<Attribute> ai = null;
            Attribute attribute = null;
            while (ei.hasNext()) {
                element = ei.next();
                // getName获取元素名称 getTextTrim获取元素内容字符串并将该内容字符串首尾祛空格
                System.out.print(element.getName() + "\t");
                // 获取该元素的所有属性
                ai = element.attributeIterator();
                while (ai.hasNext()){
                    attribute = ai.next();
                    System.out.print(attribute.getName() + " >>> " + attribute.getText().trim() + "\t");
                }
                System.out.print(element.getTextTrim() + "\n");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取节点，根据单个节点获取值*/
    public void parse03() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // selectNodes获取该节点下所有子节点
            List<Node> nodes = document.selectNodes("//books");
            // selectSingleNode获取该节点
            Node node = document.selectSingleNode("//books/book");
            // valueOf(属性的值)
            String id = node.valueOf("@id");
            String price = node.valueOf("@price");
            // getText获取该节点的内容字符串
            String text = node.getText().trim();
            System.out.println(id + "\t" + price + "\t" + text);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取节点，根据节点获取值（迭代所有节点）*/
    public void parse04() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // selectNodes获取该节点下所有子节点
            List<Node> nodes = document.selectNodes("//books/book");
            ListIterator<Node> nodeListIterator = nodes.listIterator();
            Node node = null;
            String id = null;
            String price = null;
            String text = null;
            while (nodeListIterator.hasNext()){
                node = nodeListIterator.next();
                // valueOf(属性的值)
                id = node.valueOf("@id");
                price = node.valueOf("@price");
                // getText获取该节点的内容字符串
                text = node.getText().trim();
                System.out.println(id + "\t" + price + "\t" + text);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取节点，根据条件获取节点属性值*/
    public void parse05() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // selectSingleNode获取该节点
            Node node = document.selectSingleNode("//books/book[@id=2]");
            // valueOf(属性的值)
            String id = node.valueOf("@id");
            String price = node.valueOf("@price");
            // getText获取该节点的内容字符串
            String text = node.getText().trim();
            System.out.println(id + "\t" + price + "\t" + text);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取根节点后，获取所有节点，迭代所有节点获取属性值*/
    public void parse06() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // 获取根元素(树根)
            Element root = document.getRootElement();
            // 获取根节点下所有子节点
            Iterator<Node> nodeIterator = root.nodeIterator();
            Node node = null;
            String name = null;
            String id = null;
            String price = null;
            String text = null;
            while (nodeIterator.hasNext()){
                node = nodeIterator.next();
                // getName获取节点名字
                name = node.getName();
                if (!StringUtils.isEmpty(name)){
                    // valueOf(属性的值)
                    id = node.valueOf("@id");
                    price = node.valueOf("@price");
                    // getText获取该节点的内容字符串
                    text = node.getText().trim();
                    System.out.println(name + "\t" + id + "\t" + price + "\t" + text);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取根节点后，获取所有节点，迭代所有节点获取属性值，加判断条件，标签是否为空，属性值等于多少？……*/
    public void parse07() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // 获取根元素(树根)
            Element root = document.getRootElement();
            // 获取根节点下所有子节点
            Iterator<Node> nodeIterator = root.nodeIterator();
            Node node = null;
            String name = null;
            String id = null;
            String price = null;
            String text = null;
            while (nodeIterator.hasNext()){
                node = nodeIterator.next();
                // getName获取节点名字
                name = node.getName();
                if (!StringUtils.isEmpty(name) && node.matches("@id=1")){
                    // valueOf(属性的值)
                    id = node.valueOf("@id");
                    price = node.valueOf("@price");
                    // getText获取该节点的内容字符串
                    text = node.getText().trim();
                    System.out.println(name + "\t" + id + "\t" + price + "\t" + text);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*获取根节点后，获取所有节点，迭代所有节点获取属性值，加判断条件，标签是否为空，属性值等于多少？……*/
    //parse07条件更改案例
    public void parse08() {
        // 实例化SAXReader
        SAXReader reader = new SAXReader();
        // 使用SAXReader实例化对象的read方法读取xml文件获取文档对象模型
        try {
            Document document = reader.read(in);
            // 获取根元素(树根)
            Element root = document.getRootElement();
            // 获取根节点下所有子节点
            Iterator<Node> nodeIterator = root.nodeIterator();
            Node node = null;
            String name = null;
            String id = null;
            String price = null;
            String text = null;
            while (nodeIterator.hasNext()){
                node = nodeIterator.next();
                // getName获取节点名字
                name = node.getName();
                if (!StringUtils.isEmpty(name) && node.matches("@id!=1")){
                    // valueOf(属性的值)
                    id = node.valueOf("@id");
                    price = node.valueOf("@price");
                    // getText获取该节点的内容字符串
                    text = node.getText().trim();
                    System.out.println(name + "\t" + id + "\t" + price + "\t" + text);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
