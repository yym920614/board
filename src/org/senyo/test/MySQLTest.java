package org.senyo.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.senyo.dao.BoardDAO;
import org.zerock.domain.BoardVO;

public class MySQLTest {
	
	BoardVO vo;
	

   @Test
   public void test() {
      fail("Not yet implemented");
   }

   @Test
   public void testConnection() throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = 
            DriverManager.getConnection(
                  "jdbc:mysql://192.168.0.25:3306/bit88?useSSL=false", 
                  "makemoney", 
                  "makemoney");

      System.out.println(con);
      con.close();
   }
   
   
   @Test
   public void test1() throws Exception{

//	   BoardVO vo = new BoardVO();
	   vo = new BoardVO();
	   vo.setTitle("bbbbbbb");
	   vo.setContent("bbbbbbbb");
	   vo.setWriter("bbbbbb");
	   vo.setBno(1);
	   BoardDAO.INSTANCE.update(vo);
//	   try {
//		   BoardDAO.INSTANCE.create(vo);
//		   System.out.println(vo.toString());
//	   } catch (Exception e){
//		   e.printStackTrace();
//	   }
	   
   }
   
   @Test
   public void test2() throws Exception{

	   BoardVO vo = new BoardVO();
	   
	   vo.setBno(2);

	   BoardDAO.INSTANCE.delete(vo);;

   }
   
   
   
   
   
   
   
   
   
   
   
}