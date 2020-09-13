package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;


@SpringBootApplication
@EnableSwagger2
public class ItemInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemInventoryApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("app"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {

        return new ApiInfoBuilder().title("Item Inventory")
                .description("spring-boot application with a REST controller")
                .termsOfServiceUrl(null)
                .license(null)
                .licenseUrl(null)
                .version("1.0")
                .build();


    }

}
