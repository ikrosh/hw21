package com.ex.ui;

import com.ex.pages.LoginPage;
import com.ex.pages.ProjectOverviewPage;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRailSuite extends BaseTest {

    private final String email = "myrealtestmail@mailforspam.com";
    private final String password = "neTGOS0owrzZxpyM5Knt";

    @BeforeClass
    public void login() {
        new LoginPage(webDriver, "https://myrealtestmail.testrail.io/")
                .inputEmail(email)
                .inputPassword(password)
                .clickOnLoginButton()
                .clickOnProjectLink();
    }

    @Test
    public void testCreateTestCase() {
        new ProjectOverviewPage(webDriver)
            .clickOnTestCasesTab()
            .clickOnAddTestCaseButton()
            .inputTitle(String.format("TestCase-%s", RandomStringUtils.randomAlphanumeric(5)))
            .inputSection("Test Cases")
            .inputTemplate("Test Case (Text)")
            .inputType("Functional")
            .inputPriority("High")
            .inputEstimate("44")
            .inputReferences("no")
            .inputAutomationType("None")
            .inputPreconditions("Here some preconditions")
            .inputSteps("Here some steps")
            .inputExpectedResults("ere some expected results")
            .clickOnAddTestCaseButton()
            .verifyTestCaseCreation();
    }

    @Test
    public void testFailTestRunItem() {
        new ProjectOverviewPage(webDriver)
                .clickOnTestRunsTab()
                .clickOnTestRun()
                .selectTestCase()
                .addResult()
                .verifyUpdatedStatus();
    }

}



