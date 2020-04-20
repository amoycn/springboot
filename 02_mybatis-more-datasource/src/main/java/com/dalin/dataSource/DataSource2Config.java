package com.dalin.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.dalin.mapper.user2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSource2Config {

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource.user2")
	public DataSource myDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("sqlSessionFactory2")
	public SqlSessionFactory mySqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}
	
	@Bean("transactionManager2")
	public DataSourceTransactionManager myTransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name ="sqlSessionTemplate2")
	public SqlSessionTemplate mySqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
