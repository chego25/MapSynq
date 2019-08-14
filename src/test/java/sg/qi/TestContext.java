package sg.qi;

import sg.qi.utilities.DriverManager;
import sg.qi.utilities.PageManager;

public class TestContext {

    public TestContext() {
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriver());
    }

    private DriverManager driverManager;
    private PageManager pageManager;

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

}
