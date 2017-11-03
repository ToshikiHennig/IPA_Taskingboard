package taskingBoard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login");
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll().and().logout().permitAll().and().exceptionHandling();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Test-User").password("admin1234").roles("USER");
		auth.inMemoryAuthentication().withUser("bla").password("test").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Toshiki").password("admin1234").roles("ADMIN");
	}

}
