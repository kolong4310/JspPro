package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_product_list";
		HttpSession session = request.getSession();
		
		int sizeLimit = 5* 1024 * 1024;
		String savePath="product_images";
		ServletContext context=session.getServletContext();
		String uploadFilePath=context.getRealPath(savePath);
		
		MultipartRequest multi=new MultipartRequest(request,//요청객체
				uploadFilePath,//2업로드될 파일이 저장될 파일 경로명
				sizeLimit,//3업로드될 파일의 최대크기
				"UTF-8", //4인코딩 타입
				new DefaultFileRenamePolicy() //덮어쓰디 방지
				); //이 시점을 기래 파일 저장 
		
		ProductVO productVO=new ProductVO();
		productVO.setKind(multi.getParameter("kind"));
		productVO.setName(multi.getParameter("name"));
		productVO.setPrice1(Integer.parseInt(multi.getParameter("price1")));
		productVO.setPrice2(Integer.parseInt(multi.getParameter("price2")));
		productVO.setPrice3(Integer.parseInt(multi.getParameter("price2")) - Integer.parseInt(multi.getParameter("price1")));
		productVO.setContent(multi.getParameter("content"));
		productVO.setImage(multi.getFilesystemName("image"));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.insertProduct(productVO);
		
		response.sendRedirect(url);
	}

}
