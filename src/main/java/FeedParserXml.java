import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;




public class FeedParserXml implements FeedParser{

    

    @Override
    public List<Flower> parse(String content)  {
        List<Flower> flowers = new ArrayList<>();
        try {
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    
            // Create a StringReader to read the XML content
            StringReader reader = new StringReader(content);
    
            // Unmarshal the XML content from the StringReader
            Root root = (Root) jaxbUnmarshaller.unmarshal(reader);
    
    
            // Now you can access your Java objects
            List<Row> rows = root.getRows();
    

            for (Row row : rows) {
                flowers.add(new Flower(row.getId(), row.getName(), row.getStock()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flowers;
        
    }
    
}

