package sg.qi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/MapSynqFirstLoad.feature",
                "src/test/resources/PagesNavigation.feature",
                "src/test/resources/MapPageDialogs.feature",
                "src/test/resources/SwitchingSections.feature",
                "src/test/resources/DirectionsSection.feature"
        },
        glue = {
                "sg.qi.steps",
                "sg.qi.hooks"
        },
        //dryRun = true,
        monochrome = true,
        strict = true
)
public class TestRunner {}