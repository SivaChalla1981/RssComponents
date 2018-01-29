package com.rsscomponents.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sivakumar on 26/01/2018.
 */

    @RunWith(Cucumber.class)
    @CucumberOptions(
            format = {"pretty","html:cucumber-html-reports",
                    "json: cucumber-html-reports/cucumber.json"},
            features = {"src/test/resources"},
            glue = {"com.rsscomponents.stepdefs"},
            tags = {"@RSS-01"}
    )
    public class RunCucumber {

    }


