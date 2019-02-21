package ex.aaronfae.graduation.authorization.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/*
		 * client - 实际上就是client id，要访问resource server的client，比如说mobile app or web
		 * page等等。
		 * 
		 * secret - 对应client的secret。
		 * 
		 * grant type - 指的是实现oauth2的那几种workflow，authorization_code, implicit, password,
		 * client_credential。
		 * 
		 * scopes - 授权的范围，可以自己定义一些字符串来表示。
		 */
		clients.inMemory().withClient("clientAPP").secret("123456").authorizedGrantTypes("authorization_code")
				.redirectUris("http://localhost:9000/callback").scopes("read_users");
		;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()");
	}

}
