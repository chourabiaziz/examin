package esprit.tn.examin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExaminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaminApplication.class, args);
	}

}
