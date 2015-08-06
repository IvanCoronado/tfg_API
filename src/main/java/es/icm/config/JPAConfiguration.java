package es.icm.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Class for JPA Configuration
 */
@Configuration
@EnableTransactionManagement
public class JPAConfiguration {

	/**
	 * Bean for DataSource definition
	 * 
	 * @param driverClass
	 *            driverClass
	 * @param jdbcUrl
	 *            jdbcUrl for database access
	 * @param user
	 *            user for database access
	 * @param password
	 *            password for database access
	 * @param maxPoolSize
	 *            maxPoolSize for database connection
	 * @param minPoolSize
	 *            maxPoolSize for database connection
	 * @param maxIdleTime
	 *            maxIdleTime for database connection
	 * @param testConnectionOnCheckout
	 *            Checkout database connection
	 * @param testConnectionOnCheckin
	 *            Checkin database connection
	 * @param idleConnectionTestPeriod
	 *            Test Period for database connection
	 * @return DataSource
	 * @throws PropertyVetoException
	 *             if DriverClass not supported
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource(@Value("${spring.datasource.driverClassName}") String driverClass,
			@Value("${spring.datasource.url}") String jdbcUrl, @Value("${spring.datasource.username}") String user,
			@Value("${spring.datasource.password}") String password,
			@Value("${spring.jdbc.maxPoolSize}") int maxPoolSize, @Value("${spring.jdbc.minPoolSize}") int minPoolSize,
			@Value("${spring.jdbc.maxIdleTime}") int maxIdleTime,
			@Value("${spring.jdbc.testConnectionOnCheckout}") boolean testConnectionOnCheckout,
			@Value("${spring.jdbc.testConnectionOnCheckin}") boolean testConnectionOnCheckin,
			@Value("${spring.jdbc.idleConnectionTestPeriod}") int idleConnectionTestPeriod)
					throws PropertyVetoException {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setMaxPoolSize(maxPoolSize);
		dataSource.setMinPoolSize(minPoolSize);
		dataSource.setMaxIdleTime(maxIdleTime);
		dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout);
		dataSource.setTestConnectionOnCheckin(testConnectionOnCheckin);
		dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);

		return dataSource;
	}
}