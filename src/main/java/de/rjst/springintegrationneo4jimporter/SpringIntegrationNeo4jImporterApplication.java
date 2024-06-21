package de.rjst.springintegrationneo4jimporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringIntegrationNeo4jImporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationNeo4jImporterApplication.class, args);
    }

}
