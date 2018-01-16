package demo2ui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Demo2MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("p").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("p").roles("USER");
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager();
    }

    static {
        SecurityContextHolder.setStrategyName(Demo2SecurityContextHolderStrategy.class.getName());
    }
}
