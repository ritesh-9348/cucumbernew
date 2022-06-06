package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "./Features/About.feature",
	glue= {"PageObject"},
	plugin = { "pretty","html:Reports/report.html"},
	monochrome=true
	)
public class Test2 {

}