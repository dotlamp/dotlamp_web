package com.dotlamp_web.jdbc;

import com.dotlamp_web.config.RootConfig;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSouceTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection(){
        try(Connection con = dataSource.getConnection()){
            log.info(con);
            System.out.println("con 성공");
        }catch (Exception e){
            System.err.println("con 오류"+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testMybatis(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession();
            Connection con = sqlSession.getConnection();
        ){
            log.info(sqlSession);
            log.info(con);
            System.out.println("Mybatis 성공");
        }catch (Exception e){
            System.err.println("Mybatis 오류"+e.getMessage());
            e.printStackTrace();
        }
    }
}
