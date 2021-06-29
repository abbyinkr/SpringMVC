/*======================================
   MemberInsertController.java
   - 사용자 정의 컨트롤러 클래스
   - 회원 데이터 추가 액션 처리 클래스.
   - DAO 객체에 대한 의존성 주입 준비.
     → 인터페이스 형태의 속성 구성
     → setter 메소드 추가. 
======================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구현한다.
public class MemberInsertController implements Controller
{

	// 인터페이스 타입
	private IMemberDAO dao;
	
	
	// setter 메소드 구성
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드
		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("UTF-8");
		
		// 이전 페이지(MembverList)로부터 넘어온 데이터 수신
		String name = request.getParameter("name");
		String tel = request.getParameter("telephone");
		
		try
		{
			MemberDTO member = new MemberDTO();
			member.setName(name);
			member.setTelephone(tel);
			
			dao.add(member);
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		//mav.setViewName("memberlist.action 페이지를 redirect");
		//mav.setViewName("memberlist.action 페이지를 다시 요청할 수 있도록 안내");
		// 클라이언트가 A 페이지를 요청하면 B 페이지를 다시 요청해~ 하고 쪽지를 주는 것.	
		// 클라이언트는 memberinsert.action 페이지를 요청했지만..
		// 현재 데이터 입력과 출력이 한페이지에 구성된 상태
		// 따라서 memberlist.action 으로 재안내 해줘야 한다. → redirect
		//mav.setViewName("/WEB-INF/views/MemberList.jsp"); --(X) InsertController는 이렇게 지정하면 X
		mav.setViewName("redirect:memberlist.action");
		// MemberListController 를 다시 불러~ 그러면 걔가 알아서 처리해줄거야
		
		
		return mav;

	}

}
