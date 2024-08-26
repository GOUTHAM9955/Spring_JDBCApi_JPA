package com.launch.SpringJDBCLauncher2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.launch.SpringJDBCLauncher2.dao.Details;
import com.launch.SpringJDBCLauncher2.dao.DetailsImplementationDao;

/*
 * IN THS PROJECT WE ARE GOING TO USE SPRING + JDBC API
 * 		We use connection pooling mechanism where we maintain pool of predefined connection objects and when we want to connect to DB we use existing connection
 * 		 objects and we need not close those connections.
 * One of the most commonly used connection pooling mechanism is Hikari Connection Pooling mechanism
 * 
 * In Spring boot hikari cp will come by default, we need not download those JAR's 
 * 		
 * Let's specify all the details rearding Data base in application properties
 * 			.. check how we specified url... since it is local host we can skip host and port url by 3 slashes
 * 
 * We have dao layer
 * 		1) Details pojo class
 * 		2) Interface of what we implement in dao layer
 * 		3) Getting details from DB using that interface 
 */
@SpringBootApplication
public class SpringJdbcLauncher2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(SpringJdbcLauncher2Application.class, args);
		
		DetailsImplementationDao dao = context.getBean(DetailsImplementationDao.class);
		
//		List<Details> details = dao.getMydetailsInfo();
//		
//		for(Details detail:details) {
//			System.out.println(detail);
//		}
		dao.getMydetailsInfo().forEach(i->System.out.println(i));
		
	}

}
