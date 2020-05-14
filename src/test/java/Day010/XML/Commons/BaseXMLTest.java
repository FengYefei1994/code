package Day010.XML.Commons;

import Day010.XML.xml.BaseXML;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

public class BaseXMLTest {
    @Test
    public void test01(){
        try {
            Element rootElement = (Element) BaseXML.getRootElement();
            BaseXML.getNodes(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
