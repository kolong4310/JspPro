package com.nonage.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
//메인 화면 출력을 위한 액션 클래스
public class indexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/index.jsp";
		//데이터 베이스에서 상품 정보 얻어오는 비즈니스 로직
		ProductDAO productDAO=ProductDAO.getInstance();
		ArrayList<ProductVO> newProductList=productDAO.listNewProduct();
		ArrayList<ProductVO> bestProductList=productDAO.listBestProduct();
		
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
