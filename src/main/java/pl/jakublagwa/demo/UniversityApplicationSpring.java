package pl.jakublagwa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {
		"pl.jakublagwa.university-application-spring.src",
		
})
@SpringBootApplication
public class UniversityApplicationSpring {
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplicationSpring.class, args);
    }
}
