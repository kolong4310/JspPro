package com.nonage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//요청이 들어오면 액션 객체에서 모든 비즈니스 로직을 수행하고 뷰를 결정, 액션 클래스들은 요청에 대해서 동일한 메소드로 처리하도록 하기 위해 인터페이스(Action)의 상속을 받도록 합니다
//다음은 요청에 대한 처리를 담당할 추상 메소드를 갖는 인터페이스, 인터페이스를 모든 액션 클래스가 상속 받도록 할 것
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException;
	
}
