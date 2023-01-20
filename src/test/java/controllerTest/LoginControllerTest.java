package controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import controller.LoginController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@Autowired
	private LoginController loginController;
	
	@Test
	public void testMethod() {
		
	}
}
