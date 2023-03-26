package runners;


import common.BaseTest;
import cucumberHooks.CucumberListener;
import cucumberHooks.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "cucumberHooks"},
        plugin = {"cucumberHooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber-reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
//        , tags = "@exam2_part2"
)

public class TestRunnerAllFeatures extends AbstractTestNGCucumberTests {

    private static final Logger logger = LogManager.getLogger(TestRunnerAllFeatures.class);

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("================ AFTER SUITE ================");

        logger.log(BaseTest.NOTICE,"Total:" + CucumberListener.count_totalTCs);
        logger.log(BaseTest.NOTICE,"Pass:" + CucumberListener.count_passedTCs);
        logger.log(BaseTest.NOTICE,"Failed:" + CucumberListener.count_failedTCs);
        logger.log(BaseTest.NOTICE,"Skipped:" + CucumberListener.count_skippedTCs);
    }

    WebDriver driver;

    @BeforeSuite
    public void cleanReport() {
        logger.info("================ BEFORE SUITE ================");
    }

    @BeforeSuite
    public void generateExtentReport() {
        this.driver = Hooks.openAndQuitBrowser();
        BaseTest.addExtentReportEnvironment(driver);
    }

}
