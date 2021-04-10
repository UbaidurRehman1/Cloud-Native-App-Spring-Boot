package com.ubaid.ms.restapi.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;


/**
 * <pre>
 * 1. Configure
 *      a. Authorize only authenticated requests except {@link KeyCloakSecurityConfig#LOGIN_URLS} and {@link KeyCloakSecurityConfig#SWAGGER_URLS}
 * 2. Disable CSRF
 *</pre>
 * @author ubaid
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true) //allows us to use the @RoleAllowed annotation
public class KeyCloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    private final String[] SWAGGER_URLS = {"/v3/api-docs",
            "/configuration/ui", "/swagger-resources/**",
            "/configuration/security", "/swagger-ui/index.html",
            "/webjars/**", "/swagger-ui/**"};
    private final String[] LOGIN_URLS = {"/api/auth/login"};

    /**
     * register the keycloak authentication provider with spring authentication manager
     * @param authenticationManagerBuilder spring authentication manager
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        authenticationManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
    }


    /**
     * authenticate all requests except /login & disable csrf
     * @param http httpSecurity
     * @throws Exception exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
                .authorizeRequests()
                .antMatchers(LOGIN_URLS).permitAll()
                .antMatchers(SWAGGER_URLS).permitAll()
                .anyRequest()
                .authenticated();
        http
                .csrf()
                .disable();

        //https://stackoverflow.com/questions/36968963/how-to-configure-cors-in-a-spring-boot-spring-security-application/37610988#37610988
        http.cors().configurationSource(req -> new CorsConfiguration().applyPermitDefaultValues());
    }

    /**
     *
     * @return session authentication strategy
     */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    /**
     *
     * @return config resolver which will compel keycloak to get props from the spring boot props files
     */
    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

}
