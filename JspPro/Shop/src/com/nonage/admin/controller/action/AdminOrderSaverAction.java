package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.OrderDAO;

public class AdminOrderSaverAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_order_list";
		String[] resultArr=request.getParameterValues("result");
		
		for(String oseq:resultArr){
			System.out.println(oseq);
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.updateOrderResult(oseq);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
