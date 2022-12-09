package za.ac.cput.security;

//This is a security configure
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
/**
 * @author Mbuso Kotobe
 * Date: 25 November 2022
 * */
public class Security {

    @Bean
    public UserDetailsService users() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("12345"))
                .roles("USER")
                .build());

        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("54321"))
                .roles("USER","ADMIN")
                .build());

        return manager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()

                //Graduate authentication
                .antMatchers(HttpMethod.POST,"/graduate/saveGraduate").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/graduate/readGraduate/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/graduate/updateGraduate/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/graduate/deleteGraduate/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/graduate/getGraduate").hasRole("USER")



                .and()
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
