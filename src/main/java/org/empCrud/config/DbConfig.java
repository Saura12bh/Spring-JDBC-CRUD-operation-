package org.empCrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"org.empCrud"})
public class DbConfig {
	//depedent class
		@Bean("dataSource")
		public DriverManagerDataSource  getDataSource()
		{
			DriverManagerDataSource ds=new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/spring");
			ds.setUsername("root");
			ds.setPassword("Saurabh2003");
			return ds;
		}
		
		//target class
		@Bean("jdbcTemplate")
		public JdbcTemplate getJdbcTemplate()
		{
			JdbcTemplate jt=new JdbcTemplate();
			jt.setDataSource(this.getDataSource());
			//this.getDatasource he datasource object la point krt
			return jt;
			
		}

}
