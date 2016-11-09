package org.senyo.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senyo.anno.RequestMapping;
import org.senyo.dao.TimeDAO;
import org.senyo.dao.TimeDAOImpl;

/**
 * Servlet implementation class HelloController
 */

@WebServlet("/hello/*")
public class HelloController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	
	private TimeDAO dao = new TimeDAOImpl();
       
	@RequestMapping("/hi")
	public void hi(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hello Controller hi~! called");
		
		try {
			System.out.println(dao.getTime());
			request.setAttribute("now", dao.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/bye")
	public String bye(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hello Controller bye~! called");
		
		return "bye";
		
	}

}
