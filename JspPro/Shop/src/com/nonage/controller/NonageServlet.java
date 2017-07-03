package com.nonage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.controller.action.ActionFactory;

/**
 * Servlet implementation class NonageServlet
 */
@WebServlet("/NonageServlet")
public class NonageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		//요청시 보낸 파라미터 command 값을 얻어온다
		String command=request.getParameter("command");
		System.out.println("NonageServlet에서 요청 받음을 확인 : " +command);
		
		
		//ActionFactory의 getAction()에 요청 파라미터 값을 넘겨주어 요청에 따른 액션 객체를 얻어온 후에
		//execute()메소드를 호출 하여 요청에 대한 처리가 일어나도록 한다
		ActionFactory af=ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action!=null){
			action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post 방식으로 요청시 한글 깨짐을 방지하기 위한 코드
		request.setCharacterEncoding("UTF-8");
		
		//doGet()에서만 요청에 대한 처리를 한다
		doGet(request,response);
	}

}
