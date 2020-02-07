package com.learn.fantasy.config;

import com.google.common.cache.CacheBuilder;
import com.learn.fantasy.service.CustomUserDetailsService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created by stepanferubko
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableCaching
@EnableAsync
@EnableTransactionManagement
@ComponentScan(value = "com.learn.fantasy")
public class AppConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("fullResponse", "leagueMembers", "players", "playerDetails", "playerHistories", "playerTypes", "teams") {
            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name, CacheBuilder.newBuilder()
                        .expireAfterWrite(1, TimeUnit.HOURS)
                        .build()
                        .asMap(),
                        false);
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = getUserDetails();
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/auth/register").permitAll()
                .antMatchers("/player/api/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf()
                .disable().exceptionHandling()
                .authenticationEntryPoint(unauthorizedEntryPoint()).and()
                .apply(new JwtConfigurer(jwtTokenProvider));
        http.cors();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized");
    }

    @Bean
    public UserDetailsService getUserDetails() {
        return new CustomUserDetailsService();
    }
}
