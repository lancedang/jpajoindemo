package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by qiankai02 on 2017/10/25.
 */
@SpringBootApplication
//@EnableScheduling
//@EnableConfigurationProperties(CarProperty.class)
public class MainApplication {

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }

}
