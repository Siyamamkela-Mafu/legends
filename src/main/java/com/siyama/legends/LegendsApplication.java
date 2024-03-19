package com.siyama.legends;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Explore the legends API",
				description = "This is an application to plan all the required items for" +
						"an event. You records the items required and the quantity. As you record them " +
						"you become told how much of that item is short.",
				version = "0.0.1"
		),
		servers={
		@Server(
				url="http://localhost:8080"
		)
}
)
@SpringBootApplication
public class LegendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegendsApplication.class, args);
	}

}
