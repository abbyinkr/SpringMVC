/*=====================
 * StudentController.java
 * - 컨트롤러 객체
======================*/

package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController
{
	@Autowired SqlSession sqlSession;
	
	@RequestMapping(value="/studentlist.action", method=RequestMethod.GET)
	public String studentList(ModelMap model)
	{
		// IStudentDAO.class : IStudentDAO의 클래스 → StudentDAO.xml 에서 implement
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		//IMemberDAO dao = new MemberDAO();
		
		model.addAttribute("count", dao.count());
		model.addAttribute("list", dao.list());
		
		return "/WEB-INF/views/StudentList.jsp";
	}
	@RequestMapping(value="studentinsertform.action", method=RequestMethod.GET)
	public String studentInsertForm(ModelMap model)
	{
		return "/WEB-INF/views/StudentInsertForm.jsp";
	}
	
	
	@RequestMapping(value="/studentinsert.action", method=RequestMethod.POST)
	public String studentInsert(StudentDTO s)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		dao.add(s);
		
		return "redirect:studentlist.action";
	}
	
	

}
