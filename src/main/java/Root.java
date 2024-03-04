import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Root {
    private List<Row> rows;

    @XmlElement(name = "row")
    public List<Row> getRows(){
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

}