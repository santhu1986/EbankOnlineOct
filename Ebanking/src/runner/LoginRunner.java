package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\SepEvngBatch\\Ebanking\\src\\feature\\"
		                    + "Login.feature","D:\\SepEvngBatch\\Ebanking\\src\\feature\\"
				                    + "Rolecreation.feature",
                            },glue="stepdefination",monochrome=true,
                       plugin= {"pretty","json:Target/Role/Roleresult.json"})
public class LoginRunner 
{

}
