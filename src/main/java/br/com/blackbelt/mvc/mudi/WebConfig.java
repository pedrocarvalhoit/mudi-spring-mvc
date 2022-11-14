package br.com.blackbelt.mvc.mudi;

import br.com.blackbelt.mvc.mudi.interceptor.InterceptadorDeAcessos;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//Clase que "instala" o interceptor"
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    //Adiciona o interceptor criado
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**");
    }
}
