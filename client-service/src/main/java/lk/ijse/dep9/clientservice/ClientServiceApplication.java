package lk.ijse.dep9.clientservice;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ClientServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests().mvcMatchers(HttpMethod.POST,"/api/v1/client")
				.permitAll()
				.anyRequest().authenticated()//all the other should authenticated
				.and()
				.csrf().disable()//cross side request frogary. as we do not use ssr we disable this(disable in restful as do not use state)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)//do not make sessions
				.and()
				.httpBasic()
				.and().build();
	}
	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return DigestUtils.sha256Hex(rawPassword+"");
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.matches(DigestUtils.sha256Hex(rawPassword+""));
			}
		};
	}

}
