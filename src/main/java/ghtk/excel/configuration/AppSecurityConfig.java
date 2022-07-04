//package ghtk.excel.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//	
////	@Bean
////	@Override
////	public UserDetailsService useDetailsService() {
////		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////		manager.createUser(User.withDefaultPasswordEncoder().username("bong").password("123").roles("USER").build());
////		return manager;
////	}
//	
//	
//	@Override
//	protected void configure (HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().permitAll();
//	}
//}
