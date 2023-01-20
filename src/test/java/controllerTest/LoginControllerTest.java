package controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(get("/session/logout"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/site/logout"));
	}
}
