package stepdefination;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void setup() throws Exception {
        DriverManager.setUpBrowser();
        DriverAction.maximizeBrowser();
    }
}