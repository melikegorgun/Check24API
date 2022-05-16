package Entities;

public class General {
    String tabName;
    TabContent tabContent;

    public General(String tabName, TabContent tabContent) {
        this.tabName = tabName;
        this.tabContent = tabContent;
    }

    public String getTabName() {
        return tabName;
    }

    public TabContent getTabContent() {
        return tabContent;
    }
}
