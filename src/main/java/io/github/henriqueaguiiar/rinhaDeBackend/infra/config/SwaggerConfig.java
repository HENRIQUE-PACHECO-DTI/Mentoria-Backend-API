package io.github.henriqueaguiiar.rinhaDeBackend.infra.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//Utilizando Anotation OpenAPIDefinition

//@OpenAPIDefinition(
//        info = @Info(
//                title = "Rinha de Backend API",
//                version = "Versão 1.0.0",
//                description = "API para mentoria de desenvolvimento backend.",
//                contact = @Contact(
//                        name = "Henrique Aguiar",
//                        email = "henriqueaguiarpacheco09@gmail.com",
//                        url = "https://github.com/henriqueaguiiar"
//                )
//        )
//)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Rinha de Backend API")
                        .description("API para mentoria de desenvolvimento backend.")
                        .version("Versão 1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Henrique Aguiar")
                                .email("henriqueaguiarpacheco09@gmail.com")
                                .url("https://github.com/henriqueaguiiar")));
    }
}
