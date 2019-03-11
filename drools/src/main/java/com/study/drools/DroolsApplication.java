package com.study.drools;

import com.study.drools.listenter.DroolsInitDrlFileListenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DroolsApplication {

    public static void main(String[] args) {

//        SpringApplication springApplication = new SpringApplication(DroolsApplication.class);
//        springApplication.addListeners(new DroolsInitDrlFileListenter());
//        ConfigurableApplicationContext applicationContext = springApplication.run(args);
////        applicationContext.publishEvent(new DroolsDRLEvent(new Object()));
//        applicationContext.close();

        SpringApplication.run(DroolsApplication.class, args);
    }

}
