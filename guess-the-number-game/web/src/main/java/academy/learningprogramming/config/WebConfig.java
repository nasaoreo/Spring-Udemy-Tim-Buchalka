package academy.learningprogramming.config;

import academy.learningprogramming.interceptor.RequestInterceptor;
import academy.learningprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // == bean methods ==
    @Bean
    public LocaleResolver localeResolver(){
        return new SessionLocaleResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
        registry.addViewController("home").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());

        // == Customize parameter name ==
        // LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // localeChangeInterceptor.setParamName("lang");

        registry.addInterceptor(new LocaleChangeInterceptor());
    }
}
