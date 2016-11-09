package org.senyo.dao;

import org.apache.ibatis.session.SqlSession;

public class TimeDAOImpl implements TimeDAO {

	@Override
	public String getTime() throws Exception {
		
		String result = null;
		
	      try(SqlSession session =
	    		  
	    		  MyBatisFactory.INSTANCE.factory.openSession();) {
	    	  
	         result= session.selectOne("org.senyo.dao.timeMapper.getTime");

	      } 
	      
		return result;
		
	}

}
