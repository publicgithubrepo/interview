import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.controller.PersonController;
import com.repository.PersonRepository;
import com.service.PersonService;

@SpringBootConfiguration
public class ConfigurationCls {
	
	@Bean
	public PersonController personController() {
		return new PersonController();
	}
	
	@Bean
	public PersonService personService() {
		return new PersonService();
	}
	
	
	
	
	
	

}
