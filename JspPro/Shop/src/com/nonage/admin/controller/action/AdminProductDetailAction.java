package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class AdminProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/product/productDetail.jsp";
		
		String pseq=request.getParameter("pseq");
		
		ProductDAO productDAO=ProductDAO.getInstance();
		ProductVO productVO=productDAO.getProduct(pseq);
		
		request.setAttribute("productVO", productVO);
		
		String tpage="1";
		if(request.getParameter("tpage")!=null){
			tpage=request.getParameter("tpage");
		}
		
		String kindList[]={"0","냉동식품","야채","축산","수산","과일","할인상품"};
		request.setAttribute("tpage", tpage);
		
		int index=Integer.parseInt(productVO.getKind());
		request.setAttribute("kind", kindList[index]);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
