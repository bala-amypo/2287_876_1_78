// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerConfig {
    
//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .info(new Info()
//                         .title("Skill Based Volunteer Task Assignor API")
//                         .version("1.0")
//                         .description("API for managing volunteer task assignments based on skills"));
//                      SecurityScheme bearerAuth = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT");

//         Server server = new Server()
//                 .url("https://9127.32procr.amypo.ai/")
//                 .description("Production Server");

//         return new OpenAPI()
//                 .addSecurityItem(
//                         new SecurityRequirement().addList("bearerAuth")
//                 )
//                 .components(
//                         new Components().addSecuritySchemes("bearerAuth", bearerAuth)
//                 )
//                 .servers(List.of(server));
 
//     }
// }
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        Server server = new Server()
                .url("https://9127.32procr.amypo.ai/")
                .description("Production Server");

        return new OpenAPI()
                .addSecurityItem(
                        new SecurityRequirement().addList("bearerAuth")
                )
                .info(new Info()
                        .title("Skill Based Volunteer Task Assignor API")
                        .version("1.0")
                        .description("API for managing volunteer task assignments based on skills"));
                .components(
                        new Components().addSecuritySchemes("bearerAuth", bearerAuth)
                )
                .servers(List.of(server));
    }
}