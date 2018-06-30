package in.arpit.freemarkertests;

import in.arpit.freemarkertests.service.HTMLTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreemarkerTestsApplication implements CommandLineRunner{


    @Autowired
    HTMLTransformation transformation;

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerTestsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        System.out.println(transformation.generateHTML());
    }
}
