package Entities;

import java.net.URL;
import java.util.List;

public class TabContent {

    List<Section> sections;
    String productInformationSheet;

    public TabContent(List<Section> sections, String productInformationSheet) {
        this.sections = sections;
        this.productInformationSheet = productInformationSheet;
    }

    public List<Section> getSections() {
        return sections;
    }

    public String getProductInformationSheet() {
        return productInformationSheet;
    }
}
