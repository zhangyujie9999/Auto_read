package cource.auto_read;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("cource.auto_read")
public class AutoReadApplication {

    public static void main(String[] args) {

        SpringApplication.run(AutoReadApplication.class, args);

    }
}
