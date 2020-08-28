package factory.software.santhosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunningEmployeeSpringBootApplication {

	public static void main(String[] args) {
		System.out.println("hello spring boot");
		SpringApplication.run(RunningEmployeeSpringBootApplication.class, args);
	}

}
