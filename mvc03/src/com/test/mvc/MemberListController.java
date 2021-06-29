/*==================================
   MemberListController.java
   - 사용자 정의 컨트롤러 클래스
   - 리스트 출력 액션.
   - DAO 객체에 대한 의존성 주입.
     → setter 메소드 추가.
==================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구현한다.
public class MemberListController implements Controller
{
	// 인터페이스 자료형을 취하는 속성 구성
	private IMemberDAO dao;
	
	// setter 메소드 구성
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ModelAndView mav = new ModelAndView();
		
		int count = 0;
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try
		{
			count = dao.count();
			memberList = dao.list();
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		// WebContent 폴더에서 MeberList.jsp 실행 확인후 WEB-INF 폴더로 옮길 예정
		// setViewName 은 순서가 상관없다 (페이지를 부르는 것이 아니라 설정하는 것이기 때문...)
		mav.setViewName("/WEB-INF/views/MemberList.jsp");
		mav.addObject("count", count);
		mav.addObject("memberList", memberList);
		
		return mav;
		
	}


}
