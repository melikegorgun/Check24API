package Entities;

public class ToolTip {

    String icon;
    Overlay overlay;

    public ToolTip(String icon, Overlay overlay) {
        this.icon = icon;
        this.overlay = overlay;
    }

    public String getIcon() {
        return icon;
    }
}
