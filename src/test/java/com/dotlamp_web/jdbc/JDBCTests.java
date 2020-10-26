package com.dotlamp_web.jdbc;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver"); //MySql
            //Class.forName("oracle.jdbc.driver.OracleDriver"); //Oracle
        }catch (Exception e){
            System.err.println("JDBC 에러 DRIVER LOAD 오류"+e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void testConnection(){

        Connection con;
        String url = "jdbc:mysql://";
        String server = "localhost:3306";
        String database = "edu_haenem";
        String user_name = "root";
        String password = "dotlamp";

        try{ con = DriverManager
                .getConnection(url + server + "/" + database + "?useSSL=false", user_name, password);
            log.info(con);
            System.out.println("con 성공");
        }catch (Exception e) {
            System.err.println("con 오류"+e.getMessage());
            e.printStackTrace();
        }
    }

}
