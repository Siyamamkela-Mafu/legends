package com.siyama.legends;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "legends API",
                description = "This is an application to plan all the required items for " +
                        "an event. You record the items required and the quantity. Users can assign items to each other " +
                        "or to themselves.",
                version = "0.0.1",
                contact = @Contact(
                        name = "Siyama Mafu",
                        email = "mafusiyamamkela@gmail.com"
                )

        ),
        servers = {
                @Server(
                        url = "https://legends-5g0z.onrender.com"
                )
        }
)
@SpringBootApplication
public class LegendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendsApplication.class, args);
    }

}
