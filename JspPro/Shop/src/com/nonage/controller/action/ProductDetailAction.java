package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

//상품 상세 보기 페이지로 이동하도록 하는 액션 클래스
public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="product/productDetail.jsp";
		
		String pseq=request.getParameter("pseq");
		
		ProductDAO productDAO=ProductDAO.getInstance();
		ProductVO productVO=productDAO.getProduct(pseq);
		
		request.setAttribute("productVO", productVO);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
