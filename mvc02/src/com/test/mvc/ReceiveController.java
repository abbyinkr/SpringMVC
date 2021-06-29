/*================================
   ReceiveController.java
   - 사용자 정의 컨트롤러 클래스
================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구현한다.
public class ReceiveController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		// 넘어온 값이 이름(한글) 일 수 있으니 인코딩처리
		request.setCharacterEncoding("UTF-8");
		
		// 넘어온 데이터 수신
		String userName = request.getParameter("userName");
		
		// userName 이라는 이름으로 Receive.jsp에 userName 데이터 넘기기
		mav.addObject("userName", userName);
		mav.setViewName("/WEB-INF/views/Receive.jsp");
		
		return mav;

	}

}
