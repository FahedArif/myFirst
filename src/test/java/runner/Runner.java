package runner;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(features= "src/test/java/feature",
					glue= "stepDiffination")
public class Runner extends AbstractTestNGCucumberTests{
	
	
	
	

}