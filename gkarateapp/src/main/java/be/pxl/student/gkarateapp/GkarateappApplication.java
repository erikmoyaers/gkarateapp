package be.pxl.student.gkarateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GkarateappApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkarateappApplication.class, args);
    }

}
