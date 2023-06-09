package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")			// 해당 문자열을 가진 class 파일을 찾아서 실행
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("HomeController");
		String url = request.getRequestURI();
		System.out.println(url);
		
		String viewName = "";
		
		if(url.contains("main.mvc")){
				System.out.println("main 요청");
				viewName = "main.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(viewName);
				dis.forward(request, response);
		} else if(url.contains("test1.mvc")){
				System.out.println("test 요청");

				String strNumber1 = request.getParameter("number1");
				String strNumber2 = request.getParameter("number2");
				
				int number1 = Integer.parseInt(strNumber1);
				int number2 = Integer.parseInt(strNumber2);
				
				int result = number1 + number2;
				
				request.setAttribute("result", result);
				
				viewName = "test1.jsp";
				
				RequestDispatcher dis = request.getRequestDispatcher(viewName);
				dis.forward(request, response);
		} else if(url.contains("test2.mvc")){
			System.out.println("test 요청");

			int result = Test2Service.minus(request);
			
			request.setAttribute("result", result);
			
			viewName = "test2.jsp";
			
			RequestDispatcher dis = request.getRequestDispatcher(viewName);
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
