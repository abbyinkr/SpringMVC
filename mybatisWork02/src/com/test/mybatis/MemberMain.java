/*====================
  MemberMain.java
  - 컨트롤러
====================*/


package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberMain
{
	// mybatis 객체 의존성 (자동) 주입~!!!
	@Autowired
	private SqlSession sqlSession;
	
	
	// form 안에 있는걸 넘길때는 POST 방식 !! ★ 
	// POST방식에 GET으로 더 붙으면 GET
	@RequestMapping(value = "/memberlist.action", method = RequestMethod.GET)
	public String memberList(ModelMap model)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		//IMemberDAO dao = new MemberDAO();
		
		model.addAttribute("count", dao.count());
		model.addAttribute("list", dao.list());
		
		return "/WEB-INF/views/MemberList.jsp";
	}

	@RequestMapping(value="/memberinsert.action", method=RequestMethod.POST)
	public String memberInsert(MemberDTO m)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.add(m);
		
		return "redirect:memberlist.action";
	}
	
	@RequestMapping(value="/memberdelete.action", method=RequestMethod.GET)
	public String memberDelete(MemberDTO m)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.remove(m);
		
		return "redirect:memberlist.action";
	}
	
	@RequestMapping(value="/memberupdate.action", method=RequestMethod.POST)
	public String memberUpdate(MemberDTO m)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		//System.out.println(m.getMid());
		
		dao.modify(m);
		
		return "redirect:memberlist.action";
	}
	
	
	
	
	
}
