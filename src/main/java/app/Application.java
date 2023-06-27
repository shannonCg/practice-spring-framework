package app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class Application {
    public static void main(String[] args){
		new SpringApplicationBuilder()
		.sources(Application.class)
		.run(args);
	}

}
