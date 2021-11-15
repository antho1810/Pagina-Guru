package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
    @Given("el usuario esta en la pagina de login")
    public void usuarioEstaEnPAginaDeLogin() {
    	driver.get("http://demo.guru99.com/v4/");
    }
    @When("^el usuario ingresa su usuario \"(.*)\"$")
    public void usuarioIngresaSuUsuarioCorrecto(String usuario) {
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(usuario);
    }
    
    @And("^el usuario ingresa su contrasena \"(.*)\"$")
    public void usuarioIngresaSuContrasenaCorrecta(String password) {
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
    }
    
    @And("el usuario da cliente en el boton de login")
    public void usuarioDaClicEnLogin() {
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();  	
    }
    
    @Then("el usuario puede ver el panel de la sucursal virtual")
    public void usuarioPuedeVerElPanel() {
    	String resultado = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
    	assertEquals(resultado, "Manger Id : mngr366185");
    }
    
    @Then("el usuario no puede entrar en la sucursal virtual")
    public void usuarioNoPuedeIngresar() {
    	String resultado = driver.switchTo().alert().getText();
    	assertEquals(resultado, "User or Password is not valid");
    	}

}
