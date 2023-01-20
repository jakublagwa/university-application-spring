package controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import model.UniversityForm;
import pojo.UniversityPojo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityApiControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test 
	public void testAdd() throws Exception{
		UniversityForm form = new UniversityForm();
		form.setName("Test University");
		form.setCountry("Test Country");
		
		UniversityPojo expectedUniversityPojo=convert(form);
		
		
	}
	
}
