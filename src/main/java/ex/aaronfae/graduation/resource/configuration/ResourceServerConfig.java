package ex.aaronfae.graduation.resource.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().requestMatchers().antMatchers("/api/**");
	}

	/*
	 * 跟Authorization
	 * Server进行打交道的，主要是用来校验发到ResourceServer的accesstoken是否有效。在这个RemoteTokenServices中，
	 * 我们需要传递clientId和clientSecret作为basic认证（ Authorization
	 * Server需要),它也指定了AuthorizationServer在哪里，需要访问的CheckTokenURL是什么。
	 */
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
		remoteTokenServices.setClientId("clientapp");
		remoteTokenServices.setClientSecret("123456");
		return remoteTokenServices;
	}

}
