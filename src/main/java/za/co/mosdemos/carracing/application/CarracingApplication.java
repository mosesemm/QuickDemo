package za.co.mosdemos.carracing.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "za.co.mosdemos.carracing")
public class CarracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarracingApplication.class, args);
    }
}
