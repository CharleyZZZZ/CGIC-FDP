//package org.cgic.oauth.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
//
//
///**
// * @Description
// * @Author: charleyZZZZ
// * @Date: 2019/10/12 16:55
// * @Version 1.0
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
////    @Autowired
////    private UserDetailsService userDetailsService;
////
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    public WebSecurityConfig() {
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws exception {
////        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////    @Override
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws exception {
////        return super.authenticationManagerBean();
////    }
//    //    @Override
////    protected void configure(HttpSecurity http) throws exception {
////        http
////            .csrf().disable()
////            .authorizeRequests()
////            //静态资源放行
////            .antMatchers("/static/**").permitAll()
////            //获取token api 放行
////            .antMatchers("/oauth/token").permitAll()
////            .anyRequest().authenticated();
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws exception {
//
//        ((HttpSecurity)((HttpSecurity)((AuthorizedUrl)http.authorizeRequests().antMatchers("/oauth/token/*")).authenticated().and()).csrf().disable()).httpBasic();
////        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/oauth/token/*").and().csrf
////        ((HttpSecurity) ((AuthorizedUrl) ((HttpSecurity) ((AuthorizedUrl) http.authorizeRequests()
////                .antMatchers(new String[]{"/swagger-resources/**"
////                        , "/swagger-ui.html**"
////                        , "/webjars/**"
////                        , "/oauth/token/*"}))
////                .permitAll().and())
////                .authorizeRequests().anyRequest())
////                .authenticated().and())
////                .csrf().disable();
////                .antMatchers("/**/*")
////                .and()
////                .authorizeRequests()
////// .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and().csrf().disable()
//////                .formLogin()
//////                .loginPage("/login")
//////                .permitAll()
//////                .and()
////                .logout()
////                .permitAll();
////
////        ((HttpSecurity)((HttpSecurity)((FormLoginConfigurer)((FormLoginConfigurer)((FormLoginConfigurer)((FormLoginConfigurer)((HttpSecurity)((AuthorizedUrl)((HttpSecurity)
////                ((AuthorizedUrl)http.authorizeRequests().antMatchers(new String[]{"/login", "/public/**", "/password/**",
////                        "/static/**", "/forgetPassword/**", "/wechat/**", "/env", "/autoconfig", "/beans", "/dump",
////                        "/health", "/info", "/metrics", "/mappings", "/trace"})).permitAll().and()).authorizeRequests().anyRequest()).authenticated().and()).formLogin().loginPage(this.loginDomain).authenticationDetailsSource(this.detailSource)).failureHandler(this.customAuthenticationFailureHandler)).successHandler(this.customAuthenticationSuccessHandler)).defaultSuccessUrl(this.loginSuccessUrl)).and()).logout().deleteCookies(new String[]{"access_token"}).invalidateHttpSession(true).logoutSuccessHandler(this.customLogoutSuccessHandler).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()).csrf().disable();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws exception {
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
//                .withUser("admin01")
//                .password("admin").roles("USER");
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws exception {
//        return super.authenticationManagerBean();
//    }
//
//}
