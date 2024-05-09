package br.com.fiap.spoiledgirlsclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "API Spoiled Girls Club",
		version = "1.0.0",
		description =  "API da loja Spoiled Girls Club"
	)
)
public class SpoiledgirlsclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpoiledgirlsclubApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Spoiled Girls Club";
	}

}