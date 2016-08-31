package org.dudukri.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {

	private static Logger logger= LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	
	@Test
	public void dataTime(){
		
		try {
			Connection con = ds.getConnection();
			
			logger.info(""+con);
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test
	public void nowTime(){
		logger.info(sqlSession.selectOne("TimeMapper.time"));
	}
}
