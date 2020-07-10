package com.boa.customer.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Slf4j
@EnableConfigurationProperties(VaultConfigurations.class)

public class DBconfigurations {
	
	//private Logger log = LoggerFactory.getLogger(DBconfigurations.class);
	
	@Value("${db_url}")
	private String url;
	@Value("${db_username}")
	private String userName;
	@Value("${db_password}")
	private String password;
	@Value("${db_driver-class-name}")
	private String driver;
	private DataSourceBuilder dataSourceBuilder;
	private final VaultConfigurations vaultConfiguration;
	//vault initialization
	public DBconfigurations(VaultConfigurations configuration) {
	    this.vaultConfiguration = configuration;
	   
	  }

	@Profile("prod")
	@Bean
	
	public DataSource getProdDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		/*
		 * log.info("----------------------------------------");
		 * log.info("Configuration properties"); log.info("   mysql.username is {}",
		 * vaultConfiguration.getUsername()); log.info("   mysql.password is {}",
		 * vaultConfiguration.getPassword());
		 * log.info("----------------------------------------");
		 */
		dataSourceBuilder.username(vaultConfiguration.getUsername());
		dataSourceBuilder.password(vaultConfiguration.getPassword());
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		//log.info("Production.......");
		return dataSourceBuilder.build();
		
	}
	
	@Profile("dev")
	@Bean
	public DataSource getDevDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		/*
		 * log.info("----------------------------------------");
		 * log.info("Configuration properties"); log.info("   mysql.username is {}",
		 * vaultConfiguration.getUsername()); log.info("   mysql.password is {}",
		 * vaultConfiguration.getPassword());
		 * log.info("----------------------------------------");
		 */
		dataSourceBuilder.username(vaultConfiguration.getUsername());
		dataSourceBuilder.password(vaultConfiguration.getPassword());
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		//log.info("Development.......");
		return dataSourceBuilder.build();
	}
	
	@Profile("qa")
	@Bean
	public DataSource getQADataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		/*
		 * log.info("----------------------------------------");
		 * log.info("Configuration properties"); log.info("   mysql.username is {}",
		 * vaultConfiguration.getUsername()); log.info("   mysql.password is {}",
		 * vaultConfiguration.getPassword());
		 * log.info("----------------------------------------");
		 */
		dataSourceBuilder.username(vaultConfiguration.getUsername());
		dataSourceBuilder.password(vaultConfiguration.getPassword());
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		//log.info("QA......");
		return dataSourceBuilder.build();
	}
	
	@Profile("test")
	@Bean
	public DataSource getTestDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		/*
		 * log.info("----------------------------------------");
		 * log.info("Configuration properties"); log.info("   mysql.username is {}",
		 * vaultConfiguration.getUsername()); log.info("   mysql.password is {}",
		 * vaultConfiguration.getPassword());
		 * log.info("----------------------------------------");
		 */
		dataSourceBuilder.username(vaultConfiguration.getUsername());
		dataSourceBuilder.password(vaultConfiguration.getPassword());
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		//log.info("Test.......");
		return dataSourceBuilder.build();
	}

}
