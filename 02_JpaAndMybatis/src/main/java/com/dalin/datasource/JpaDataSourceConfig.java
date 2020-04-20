package com.dalin.datasource;

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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.dalin.mapper.jpa", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class JpaDataSourceConfig {

	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.datasource.jpa")
	@Primary
	public DataSource myDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("sqlSessionFactory1")
	@Primary
	public SqlSessionFactory mySqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}
	
	@Bean("transactionManager1")
	@Primary
	public DataSourceTransactionManager myTransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name ="sqlSessionTemplate1")
	@Primary
	public SqlSessionTemplate mySqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
