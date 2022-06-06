package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "./Features/Menu.feature",
	glue= {"PageObject"},
	plugin = { "pretty","html:Reports/report.html"},
	monochrome = true
	)
public class Test5 {

}
