package com.nonage.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.action.Action;
import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class AdminQnaResaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_qna_list";
		
		String qseq=request.getParameter("qseq");
		String reply=request.getParameter("reply");
		
		QnaVO qnaVO=new QnaVO();
		qnaVO.setQseq(Integer.parseInt(qseq));
		qnaVO.setReply(reply);
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.updateQna(qnaVO);
		
		
		response.sendRedirect(url);
	}

}