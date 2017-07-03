package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/product/productUpdate.jsp";
		
		String pseq=request.getParameter("pseq");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO productVO=productDAO.getProduct(pseq);
		
		request.setAttribute("productVO", productVO);
		
		String tpage="1";
		
		if(request.getParameter("tpage")!=null){
			tpage=request.getParameter("tpage");
		}
		
		request.setAttribute("tpage", tpage);
		
		String kindList[]={"냉동식품","야채","축산","수산","과일","할인상품"};
		request.setAttribute("kindList", kindList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
