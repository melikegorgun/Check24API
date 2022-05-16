package Entities;

public class Row {

    String label;
    ToolTip toolTip;
    String value;
    String featuredDetail;

    public Row(String label, ToolTip toolTip, String value, String featuredDetail) {
        this.label = label;
        this.toolTip = toolTip;
        this.value = value;
        this.featuredDetail = featuredDetail;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public String getFeaturedDetail() {
        return featuredDetail;
    }

    public ToolTip getToolTip() {
        return toolTip;
    }
}
