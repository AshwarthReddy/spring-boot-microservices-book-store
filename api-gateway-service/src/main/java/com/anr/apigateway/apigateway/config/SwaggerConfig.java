// package com.anr.apigateway.apigateway.config;
//
// import static org.springdoc.core.utils.Constants.DEFAULT_API_DOCS_URL;
//
// import jakarta.annotation.PostConstruct;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
// import org.springdoc.core.properties.SwaggerUiConfigProperties;
// import org.springframework.cloud.gateway.route.RouteDefinition;
// import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// @RequiredArgsConstructor
// @Slf4j
// class SwaggerConfig {
//    private final RouteDefinitionLocator locator;
//    private final SwaggerUiConfigProperties swaggerUiConfigProperties;
//
//    @PostConstruct
//    public void init() {
//        List<RouteDefinition> definitions =
//                locator.getRouteDefinitions().collectList().block();
//        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
//        definitions.stream()
//                .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
//                .forEach(routeDefinition -> {
//                    String name = routeDefinition.getId().replaceAll("-service", "");
//                    AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl =
//                            new AbstractSwaggerUiConfigProperties.SwaggerUrl(
//                                    name, DEFAULT_API_DOCS_URL + "/" + name, null);
//                    urls.add(swaggerUrl);
//                    log.info("Swagger name {} and url {}", name, swaggerUrl);
//                });
//        swaggerUiConfigProperties.setUrls(urls);
//    }
// }
