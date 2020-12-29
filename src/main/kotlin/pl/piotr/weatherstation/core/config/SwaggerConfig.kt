package pl.piotr.weatherstation.core.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

  @Bean
  fun docket(): Docket = Docket(DocumentationType.SWAGGER_2)
    .useDefaultResponseMessages(false)
    .select()
    .apis(RequestHandlerSelectors.basePackage("pl.piotr.weatherstation"))
    .paths(PathSelectors.ant("/api/**"))
    .build()
}
