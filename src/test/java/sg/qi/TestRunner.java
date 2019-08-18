package sg.qi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/MapSynqFirstLoad.feature",
                "src/test/resources/features/PagesNavigation.feature",
                "src/test/resources/features/MapPageDialogs.feature",
                "src/test/resources/features/SwitchingSections.feature",
                "src/test/resources/features/DirectionsSection.feature",
                "src/test/resources/features/PersonalSection.feature",
                "src/test/resources/features/LiveSection.feature",
                "src/test/resources/features/GlobalSearch.feature"
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