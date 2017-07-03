package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
//상품 분류별 상품 리스트 페이지로 이동하도록 하는 액션 클래스
public class ProductKindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="product/productKind.jsp";
		
		String kind=request.getParameter("kind");
		
		ProductDAO productDAO=ProductDAO.getInstance();
		//ArrayList로 쓰는 이유는 productDAO의 listkindProduct를 ArrayList로 만들었기 때문?
		ArrayList<ProductVO> productKindList=productDAO.listKindProduct(kind);
		
		request.setAttribute("productKindList", productKindList);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);
	}

}
