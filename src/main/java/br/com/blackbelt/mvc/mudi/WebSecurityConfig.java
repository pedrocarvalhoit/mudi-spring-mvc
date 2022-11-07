package br.com.blackbelt.mvc.mudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //Permite vizualização da home por qualquer usuário
                .antMatchers("/home/**")
                    .permitAll()
                .anyRequest()
                        .authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        //Direciona para home sempre que login tem sucesso
                        .defaultSuccessUrl("/usuario/produto", true)
                        .permitAll()
                )
                //Define redirecionamento pra página de lougout
                .logout(logout ->{
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/home");
                   //     .csrf().disable();
                });
    }

    //Método que salva usuário no banco de dados
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Criptogragia
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder);

//		UserDetails user =
//				 User.builder()
//					.username("maria")
//					.password(encoder.encode("maria"))
//					.roles("ADM")
//					.build();
    }

}
