package controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void loginTest() throws Exception{
		mockMvc.perform(post("/session/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "test@example.com")
				.param("password", "password"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/site/login"));
	}
	
	@Test
	public void loginTestWithWrongCredentials() throws Exception{
		mockMvc.perform(post("/session/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "test@example.com")
				.param("password", "wrongpassword"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/site/login"))
				.andExpect(model().attribute("error", "Invalid"
						+ " username or password"));
	}
	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(get("/session/logout"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/site/logout"));
	}
}
