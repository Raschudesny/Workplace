package danilo.laks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //solution to connection via https SSL problem
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        System.out.println(new File("") .getAbsolutePath());
        SpringApplication.run(Main.class, args);

    }
}
