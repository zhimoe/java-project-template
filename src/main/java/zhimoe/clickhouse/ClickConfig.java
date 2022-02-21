package zhimoe.clickhouse;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/5
 */
@Data
@Component
public class ClickConfig {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.connectionTimeout}")
	private Integer connectionTimeout;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

}
